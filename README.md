# Restaurant Management Project

A Java-based application for managing various aspects of a restaurant's operations, including order processing, menu management, and inventory tracking. The project leverages JDBC with PostgreSQL for database interactions and provides a Swing-based graphical user interface.

## Table of Contents
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Setup and Installation](#setup-and-installation)
- [Usage](#usage)
- [Project Structure](#project-structure)


## Features
- **Order Management**: Create, modify, and cancel orders efficiently.
- **Menu Management**: Add, update, or remove menu items.
- **Inventory Management**: Track inventory levels and issue alerts for low stock.
- **Billing System**: Generate bills for customer orders.
- **Admin Authentication**: Secure login for administrative control.

## Technologies Used
- **Java (JDK)**: Primary language for application logic.
- **PostgreSQL**: Database for storing and managing restaurant data.
- **JDBC**: Java Database Connectivity for database interactions.
- **Swing (Java GUI)**: Provides a graphical user interface for the application.

## Setup and Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/lisa0403/Restaurant-Project-in-java-.git
Open the project in your IDE (e.g., Eclipse, IntelliJ).

## Setup and Installation

### Set up PostgreSQL Database
1. **Create Database**: Set up a PostgreSQL database named `restaurant`.
2. **Database Connection**: Update the database connection details as necessary in your code:
    Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/restaurant", "postgres", "12345");


## Setup and Installation

### Compile the Program
To compile the program, ensure that the PostgreSQL JDBC driver (`postgresql-42.7.3.jar`) is included in the classpath:
```bash
javac -cp ";postgresql-42.7.3.jar" Program.java

Replace Program.java with the main class file name to execute the program.

## **Usage**

- **Start the Application**: Launch the application from your IDE or command line after compilation.
- **Log In**: Use admin credentials to access management features.
- **Manage Operations**:
  - Handle orders, manage inventory, and update menu items.
  - Generate and print bills as needed.

## **Project Structure**

- **src/**: Contains Java source files.
- **database/**: SQL scripts for setting up the database tables.
- **lib/**: Includes external libraries like the PostgreSQL JDBC driver (`postgresql-42.7.3.jar`).
- **resources/**: Images, icons, and other media assets used in the UI.




