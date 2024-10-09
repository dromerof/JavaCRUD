package org.dromerof.main;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

        Connection myConn = null;
        Statement myStant = null;
        ResultSet myRes = null;

        try {
            // 1. Connexion a nuestra base de datos
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "dromerof");
            // 2. Crear una declaración objeto
            myStant = myConn.createStatement();
            // 3. Ejecutar consulta SQL
            myRes = myStant.executeQuery("SELECT * FROM employees");

            while (myRes.next()) {
                System.out.println(myRes.getString("first_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Algo salio mal");
        }

    }
}
