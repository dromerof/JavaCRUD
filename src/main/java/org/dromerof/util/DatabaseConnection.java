package org.dromerof.util;

import io.github.cdimascio.dotenv.Dotenv;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnection {
    static Dotenv dotenv = Dotenv.load();

    private static final String dbUrl = dotenv.get("DB_URL");
    private static final String dbUser = dotenv.get("DB_USER");
    private static final String dbPassword = dotenv.get("DB_PASSWORD");

    private static BasicDataSource pool;

    public static BasicDataSource getInstance() {
        if (pool == null) {
            pool = new BasicDataSource();
            pool.setUrl(dbUrl);
            pool.setUsername(dbUser);
            pool.setPassword(dbPassword);

            pool.setInitialSize(3);
            pool.setMinIdle(2);
            pool.setMaxIdle(10);
            pool.setMaxTotal(10);
        }
        return pool;
    }

    public static Connection getConnection() throws SQLException {
        return getInstance().getConnection();
    }
}
