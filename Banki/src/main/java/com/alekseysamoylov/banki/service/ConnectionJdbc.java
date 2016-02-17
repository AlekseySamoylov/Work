package com.alekseysamoylov.banki.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by alekseysamoylov on 2/17/16.
 */
public class ConnectionJdbc {
    private static Connection connection;

    public static Connection getConnection() {
        try {
            Class.forName(Settings.getInstance().value("jdbc.driver_class"));
            Connection connection = DriverManager.getConnection(
                    Settings.getInstance().value("jdbc.url"),
                    Settings.getInstance().value("jdbc.username"),
                    Settings.getInstance().value("jdbc.password"));
            ConnectionJdbc.connection = connection;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection() throws SQLException {
        connection.close();
    }
}
