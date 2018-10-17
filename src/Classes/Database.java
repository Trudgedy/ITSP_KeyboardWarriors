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
import java.util.Calendar;

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

    // For reports. Will be implemented later.
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
            PreparedStatement pst = conn.prepareStatement("SELECT order_id , suppliers.name, amount, date FROM `orders` INNER JOIN suppliers ON orders.itemid = suppliers.supplierid WHERE date >= DATE(NOW()) - INTERVAL " + range + "");
            rs = pst.executeQuery();

            if (rs.next()) {

                while (rs.next()) {
                    Order order = new Order();
                    order.setOrderid(rs.getInt(1));
                    order.setBusinessname(rs.getString(2));
                    order.setAmount(rs.getInt(3));
                    order.setDate(rs.getString(4));
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

    }

    //To format date. SELECT DATE_FORMAT(date,"%Y/%m/%e") FROM orders;
    // For invoices. Will implement later.
    public static ArrayList<Order> getInvoice() {
        ArrayList<Order> Arr = new ArrayList<>();
        try {
            connect_db();
            PreparedStatement pst = conn.prepareStatement("SELECT order_id , suppliers.name, amount, date FROM `orders` INNER JOIN suppliers ON orders.itemid = suppliers.supplierid WHERE paid = 1");
            rs = pst.executeQuery();

            if (rs.next()) {

                while (rs.next()) {
                    Order order = new Order();
                    order.setOrderid(rs.getInt(1));
                    order.setBusinessname(rs.getString(2));
                    order.setAmount(rs.getInt(3));
                    order.setDate(rs.getString(4));
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

    public static ArrayList<Item> getItem() {

        ArrayList<Item> Arr = new ArrayList<>();
        try {
            connect_db();
            PreparedStatement pst = conn.prepareStatement("SELECT itemid,item,price,quantity,suppliers.name FROM `items` INNER JOIN suppliers ON items.supplierid = suppliers.supplierid");
            rs = pst.executeQuery();

            if (rs.next()) {

                while (rs.next()) {
                    Item item = new Item();
                    item.setItemid(rs.getInt(1));
                    item.setItemName(rs.getString(2));
                    item.setPrice(rs.getInt(3));
                    item.setQuantity(rs.getInt(4));
                    item.setSupplierName(rs.getString(5));
                    Arr.add(item);
                }

                return Arr;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Caught exception: " + e);
            return null;
        }

    }

    // Inserts new order.
    public static boolean insertOrder(int itemid, int price) {
        try {

            Calendar calendar = Calendar.getInstance();
            java.sql.Date date = new java.sql.Date(calendar.getTime().getTime());

            connect_db();
            PreparedStatement pst = conn.prepareStatement("INSERT INTO orders (itemid,amount,date) VALUES (?, ?, ?)");
            pst.setInt(1, itemid);
            pst.setInt(2, price);
            pst.setDate(3, date, calendar);
            pst.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Caught exception: " + e);
            return false;
        }

    }

    public static boolean updateOrder(int orderid) {

        try {

            connect_db();
            PreparedStatement pst = conn.prepareStatement("UPDATE orders SET paid = (1) WHERE order_id = " + orderid + "");
            pst.setInt(1, orderid);
            pst.executeUpdate();
            return true;

        } catch (SQLException e) {

            System.out.println("Caught exception: " + e);
            return false;
        }

    }

    static void connect_db() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/itspdb", "root", "");
            statement = conn.createStatement();
            System.out.println("Database connection successful.");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.print("Could not connect connect to the database. - Error:" + e);
        }
    }

}
