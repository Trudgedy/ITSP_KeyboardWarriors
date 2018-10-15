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
import java.util.ArrayList;

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

    public static ArrayList<Order> getOrders(int x) {

        ArrayList<Order> Arr = new ArrayList<>();
        String range;

        if (x == 1) {
            range = "1 YEAR";
        } else {
            range = "1 MONTH";
        }

        try {
            connect_db();
            PreparedStatement pst = conn.prepareStatement("SELECT date,description,amount FROM `orders` WHERE date >= DATE(NOW()) - INTERVAL " + range + "");
            rs = pst.executeQuery();

            if (rs.next()) {

                while (rs.next()) {
                    Order order = new Order();
                    order.setDate(rs.getString(1));
                    order.setDescription(rs.getString(2));
                    order.setAmount(rs.getInt(3));
                    Arr.add(order);
                }

                return Arr;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Caught exception: " + e);
            return null;
        }

        /* 
        For anyone confused as to how to use this, here ArrayList<Order> Arr = Database.getOrders();
        
        for (int i = 0; i < Arr.size(); i++) {

            System.out.println("The date is :" + Arr.get(i).getDate());
            System.out.println("The amount is :" + Arr.get(i).getAmount());
            System.out.println("The description is :" + Arr.get(i).getDescription());
        } */
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
