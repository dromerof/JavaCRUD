package org.dromerof.util;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    static Dotenv dotenv = Dotenv.load();

    private static final String dbUrl = dotenv.get("DB_URL");
    private static final String dbUser = dotenv.get("DB_USER");
    private static final String dbPassword = dotenv.get("DB_PASSWORD");

    private static Connection myConn;

    public static Connection getInstance() throws SQLException {
        if(myConn == null){
            myConn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        }
        return myConn;
    }

}
