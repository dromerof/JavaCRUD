package org.dromerof.main;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        // Cargar las variables de entorno desde el archivo .env
        Dotenv dotenv = Dotenv.load();

        // Leer las variables de entorno
        String dbUrl = dotenv.get("DB_URL");
        String dbUser = dotenv.get("DB_USER");
        String dbPassword = dotenv.get("DB_PASSWORD");

        Connection myConn = null;
        Statement myStant = null;
        ResultSet myRes = null;

        try {
            // 1. Conexión a nuestra base de datos usando las variables de entorno
            myConn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            // 2. Crear una declaración objeto
            myStant = myConn.createStatement();
            // 3. Ejecutar consulta SQL
            myRes = myStant.executeQuery("SELECT * FROM employees");

            while (myRes.next()) {
                System.out.println(myRes.getString("first_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Algo salió mal");
        }
    }
}
