/**
 * Created by dplichta on 2015-08-04.
 */

package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FirstExample {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/mysql";
    static final String USER = "root";
    static final String PASS = "root";

    public FirstExample() {
    }

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/mysql", "root", "root");
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String se = "SELECT host, user, password FROM user";
            ResultSet rs = stmt.executeQuery(se);

            while(rs.next()) {
                String age = rs.getString("host");
                String first = rs.getString("user");
                String last = rs.getString("password");
                System.out.print(", Age: " + age);
                System.out.print(", First: " + first);
                System.out.println(", Last: " + last);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException var23) {
            var23.printStackTrace();
        } catch (Exception var24) {
            var24.printStackTrace();
        } finally {
            try {
                if(stmt != null) {
                    stmt.close();
                }
            } catch (SQLException var22) {
                ;
            }

            try {
                if(conn != null) {
                    conn.close();
                }
            } catch (SQLException var21) {
                var21.printStackTrace();
            }

        }

        System.out.println("Goodbye!");
    }
}
