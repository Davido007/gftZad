package com.gft.com.gft.db;

/**
 * Created by dplichta on 2015-08-05.
 */

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DatabaseAccess {

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Context test = new InitialContext();
            DataSource ds = (DataSource) test.lookup("java:comp/env/jdbc/TestDB");
            connection = ds.getConnection();
        } catch (NamingException e1) {
            e1.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    public static void closeConenction(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
}

