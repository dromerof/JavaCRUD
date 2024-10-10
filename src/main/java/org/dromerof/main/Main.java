package org.dromerof.main;

import org.dromerof.util.DatabaseConnection;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

             // 1. Conexión a nuestra base de datos usando las variables de entorno
        try (Connection myConn = DatabaseConnection.getInstance();
             // 2. Crear una declaración objeto
             Statement myStand = myConn.createStatement();
             // 3. Ejecutar consulta SQL
             ResultSet myRes = myStand.executeQuery("SELECT * FROM employees");){

            while (myRes.next()) {
                System.out.println(myRes.getString("first_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Algo salió mal");
        }
    }
}
