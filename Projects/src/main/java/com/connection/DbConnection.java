package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    public Connection conn = null;

    public Connection getConnection() throws InstantiationException, IllegalAccessException {

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database1", "root", "harshi29");
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        } catch(Exception e){
            System.out.println(e.getMessage());
        }

        return conn;
    }
}
