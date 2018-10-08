/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author hamme
 */
public class Database {

    static Connection conn;
    static Statement statement;
    static ResultSet rs;

    public static String[] getPassword(String username) {

        String[] password = new String[2];

        try {
            connect_db();
            PreparedStatement pst = conn.prepareStatement("SELECT password,salt FROM `user` WHERE username=?");
            pst.setString(1, username);
            rs = pst.executeQuery();

            if (rs.next()) {
                password[0] = rs.getString("password");
                password[1] = rs.getString("salt");
                return password;
            }

        } catch (SQLException e) {
            System.out.print("Could not connect retrieve username. - Error:" + e);

        }
        return password;
    }

    static void connect_db() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/itspdb", "root", "");
            statement = conn.createStatement();
            System.out.println("Database connection successful.");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.print("Could not connect connect to the database. - Error:" + e);
        }
    }

}
