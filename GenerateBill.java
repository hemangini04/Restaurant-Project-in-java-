import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class GenerateBill extends JFrame {
    JTextField food, quantity;
    String[] columnNames = {"Food Name", "Quantity", "Price"};

    JLabel totalP = new JLabel();
    Object data[][] = new Object[100][3];
    JTable cart = new JTable(new DefaultTableModel(data, columnNames));
    double totalprice = 0;
    ArrayList<foodCart> foodList = new ArrayList<>();

    GenerateBill() {
        JPanel jp1 = new JPanel();
        setBackground(Color.red);
        this.setLayout(new GridLayout(2, 2));
        JLabel a = new JLabel("Food Name : ");
        jp1.add(a);
        food = new JTextField(50);
        jp1.add(food);
        JLabel b = new JLabel("Quantity : ");
        jp1.add(b);
        quantity = new JTextField(50);
        jp1.add(quantity);

        JButton ok = new JButton("OK");

        JPanel jp2 = new JPanel();
        jp2.setLayout(new BorderLayout()); // Set layout to BorderLayout for proper display
        jp1.add(ok);
        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("org.postgresql.Driver");
                    Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/canteenmanagement", "postgres", "12345");
                    PreparedStatement pst = con.prepareStatement("SELECT f_prize FROM food WHERE f_name = ?");
                    pst.setString(1, food.getText());
                    ResultSet rs = pst.executeQuery();

                    DefaultTableModel model = (DefaultTableModel) cart.getModel();
                    model.setRowCount(0);

                    while (rs.next()) {
                        foodCart f = new foodCart();
                        f.name = food.getText();
                        f.quantity = Integer.parseInt(quantity.getText());
                        f.totalPer = f.quantity * rs.getDouble("f_prize");
                        totalprice += f.totalPer;
                        foodList.add(f);
                        Object[] row = {f.name, f.quantity, f.totalPer};
                        model.addRow(row);
                    }

                    totalP.setText("TOTAL Price : " + Double.toString(totalprice) + "tk");

                    food.setText("");
                    quantity.setText("");

                    rs.close();
                    pst.close();
                    con.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        jp2.add(new JScrollPane(cart), BorderLayout.CENTER); // Add the JTable to the panel

        jp2.add(totalP, BorderLayout.SOUTH); // Add the total price label to the panel

        this.add(jp1);
        this.add(jp2);
        this.setSize(600, 550);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    class foodCart {
        String name;
        Double totalPer;
        int quantity;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GenerateBill());
    }
}
