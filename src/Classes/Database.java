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

            while (rs.next()) {
                Order order = new Order();
                order.setOrderid(rs.getInt(1));
                order.setBusinessname(rs.getString(2));
                order.setAmount(rs.getInt(3));
                order.setDate(rs.getString(4));
                Arr.add(order);
            }

            return Arr;

        } catch (SQLException e) {
            System.out.println("Caught exception: " + e);
            return null;
        }

    }

    //To format date. SELECT DATE_FORMAT(date,"%Y/%m/%e") FROM orders;
    // For invoices. Will implement later.
    public static ArrayList<Order> getPaidOrders(int x) {
        ArrayList<Order> Arr = new ArrayList<>();
        String range;

        if (x == 1) {
            range = "1 YEAR";
        } else {
            range = "1 MONTH";
        }
        try {
            connect_db();
            PreparedStatement pst = conn.prepareStatement("SELECT order_id, suppliers.name, amount, date FROM `orders` JOIN items ON orders.itemid = items.itemid JOIN suppliers ON items.supplierid = suppliers.supplierid WHERE paid = 1 AND date >= DATE(NOW()) - INTERVAL " + range + "");
            rs = pst.executeQuery();

            while (rs.next()) {
                Order order = new Order();
                order.setOrderid(rs.getInt(1));
                order.setBusinessname(rs.getString(2));
                order.setAmount(rs.getInt(3));
                order.setDate(rs.getString(4));
                Arr.add(order);
            }

            return Arr;

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

    public static ArrayList<Order> getUnpaidOrders() {
        ArrayList<Order> Arr = new ArrayList<>();
        try {
            connect_db();
            PreparedStatement pst = conn.prepareStatement("SELECT order_id , suppliers.name, amount, date, items.item, orders.quantity FROM `orders` INNER JOIN suppliers ON orders.itemid = suppliers.supplierid INNER JOIN items ON orders.itemid = items.itemid WHERE paid = 0");
            rs = pst.executeQuery();

            while (rs.next()) {
                Order order = new Order();
                order.setOrderid(rs.getInt(1));
                order.setBusinessname(rs.getString(2));
                order.setAmount(rs.getInt(3));
                order.setDate(rs.getString(4));
                order.setItem(rs.getString(5)); // Returns the item name as well so that the user can at least see what they ordered.
                order.setQuantity(rs.getInt(6)); // Returns the orders quantity.
                Arr.add(order);
            }

            return Arr;

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

    // Retrieves the sales from the database to be used in the report generation.
    public static ArrayList<Sale> getSales(int x) {

        ArrayList<Sale> Arr = new ArrayList<>();
        String range;

        if (x == 1) {
            range = "1 YEAR";
        } else {
            range = "1 MONTH";
        }

        try {
            connect_db();
            PreparedStatement pst = conn.prepareStatement("SELECT dateofsale, sales.price, sales.quantity, items.item FROM `sales` INNER JOIN items ON sales.itemid = items.itemid WHERE dateofsale >= DATE(NOW()) - INTERVAL " + range + "");
            rs = pst.executeQuery();

            while (rs.next()) {
                Sale sale = new Sale();
                sale.setDateofsale(rs.getString(1));
                sale.setPrice(rs.getInt(2));
                sale.setQuantity(rs.getInt(3));
                sale.setItemName(rs.getString(4));
                Arr.add(sale);
            }

            return Arr;

        } catch (SQLException e) {
            System.out.println("Caught exception: " + e);
            return null;
        }

    }

    //Retrieves all the items from database.
    public static ArrayList<Item> getItems() {

        ArrayList<Item> Arr = new ArrayList<>();
        try {
            connect_db();
            PreparedStatement pst = conn.prepareStatement("SELECT itemid,item,price,quantity,suppliers.name FROM `items` INNER JOIN suppliers ON items.supplierid = suppliers.supplierid");
            rs = pst.executeQuery();

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

        } catch (SQLException e) {
            System.out.println("Caught exception: " + e);
            return null;
        }

    }

    //Retrieves item from the database with name as an identifier.
    public static ArrayList<Item> getItemsByName(String Name) {

        ArrayList<Item> Arr = new ArrayList<>();
        try {
            connect_db();
            PreparedStatement pst = conn.prepareStatement("SELECT itemid,item,price,quantity,suppliers.name FROM `items` INNER JOIN suppliers ON items.supplierid = suppliers.supplierid WHERE item = '" + Name + "'");
            rs = pst.executeQuery();

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

        } catch (SQLException e) {
            System.out.println("Caught exception: " + e);
            return null;
        }

    }

    //Retrieves item from the database with supplier as an identifier.
    public static ArrayList<Item> getItemsBySupplier(String supplier) {

        ArrayList<Item> Arr = new ArrayList<>();
        try {
            connect_db();
            PreparedStatement pst = conn.prepareStatement("SELECT itemid,item,price,quantity,suppliers.name FROM `items` INNER JOIN suppliers ON items.supplierid = suppliers.supplierid WHERE suppliers.name = " + supplier + "");
            rs = pst.executeQuery();

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

        } catch (SQLException e) {
            System.out.println("Caught exception: " + e);
            return null;
        }

    }

    //Retrieves item from the database with supplier and item name as an identifier.
    public static ArrayList<Item> getItemsByNameAndSupplier(String name, String supplier) {

        ArrayList<Item> Arr = new ArrayList<>();
        try {
            connect_db();
            PreparedStatement pst = conn.prepareStatement("SELECT itemid,item,price,quantity,suppliers.name FROM `items` INNER JOIN suppliers ON items.supplierid = suppliers.supplierid WHERE item = " + name + " AND suppliers.name = " + supplier + "");
            rs = pst.executeQuery();

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

        } catch (SQLException e) {
            System.out.println("Caught exception: " + e);
            return null;
        }

    }

    // Inserts new order.
    public static boolean insertOrder(int itemId, int price, int quantity) {
        try {

            Calendar calendar = Calendar.getInstance();
            java.sql.Date date = new java.sql.Date(calendar.getTime().getTime());

            connect_db();
            PreparedStatement pst = conn.prepareStatement("INSERT INTO orders (itemid,amount,date,quantity,paid) VALUES (?, ?, ?, ?, 0)");
            pst.setInt(1, itemId);
            pst.setInt(2, price);
            pst.setDate(3, date, calendar);
            pst.setInt(4, quantity);
            pst.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Caught exception: " + e);
            return false;
        }

    }

    // View suppliers.
    public static ArrayList<Supplier> viewSupplier() {

        ArrayList<Supplier> Arr = new ArrayList<>();
        try {

            connect_db();
            PreparedStatement pst = conn.prepareStatement("SELECT name, email, number, address, vatstatus FROM `suppliers`");
            rs = pst.executeQuery();

            while (rs.next()) {
                Supplier supplier = new Supplier();
                supplier.setName(rs.getString(1));
                supplier.setEmail(rs.getString(2));
                supplier.setNumber(rs.getString(3));
                supplier.setAddress(rs.getString(4));
                supplier.setVatstatus(rs.getBoolean(5));
                Arr.add(supplier);
            }

            return Arr;

        } catch (SQLException e) {
            System.out.println("Caught exception: " + e);
            return null;
        }

    }

    public static Supplier getSupplierByName(String name) {

        try {

            connect_db();
            PreparedStatement pst = conn.prepareStatement("SELECT name, email, number, address, vatstatus FROM `suppliers` WHERE name = '" + name + "'");

            rs = pst.executeQuery();
            Supplier supplier = new Supplier();

            while (rs.next()) {

                supplier.setName(rs.getString(1));
                supplier.setEmail(rs.getString(2));
                supplier.setNumber(rs.getString(3));
                supplier.setAddress(rs.getString(4));
                supplier.setVatstatus(rs.getBoolean(5));

            }
            return supplier;

        } catch (SQLException e) {
            System.out.println("Caught exception: " + e);
            return null;
        }

    }

    public static boolean ifSupplierExists(String name) {

        try {

            connect_db();
            PreparedStatement pst = conn.prepareStatement("SELECT name, email, number, address, vatstatus FROM `suppliers` WHERE name = '" + name + "'");
            rs = pst.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            System.out.println("Caught exception: " + e);
            return false;
        }

    }

    // Inserts new supplier. Send through supplier object.
    public static boolean insertSupplier(Supplier supplier) {
        try {
            connect_db();

            PreparedStatement pst = conn.prepareStatement("SELECT * FROM suppliers WHERE name = '" + supplier.getName() + "'");
            rs = pst.executeQuery();

            if (!rs.next()) {

                pst = conn.prepareStatement("INSERT INTO suppliers (name,email,number,address,vatstatus) VALUES (?, ?, ?, ?, ?)");
                pst.setString(1, supplier.getName());
                pst.setString(2, supplier.getEmail());
                pst.setString(3, supplier.getNumber());
                pst.setString(4, supplier.getAddress());
                pst.setBoolean(5, supplier.isVatstatus());
                pst.executeUpdate();
                return true;

            } else {

                return false;

            }

        } catch (SQLException e) {
            System.out.println("Caught exception: " + e);
            return false;
        }

    }

    // Deletes supplier.
    public static boolean deleteSupplier(String name) {
        try {
            connect_db();
            PreparedStatement pst = conn.prepareStatement("SELECT supplierid FROM suppliers WHERE name = '" + name + "'");

            rs = pst.executeQuery();

            if (rs.next()) {

                pst = conn.prepareStatement("DELETE FROM suppliers WHERE supplierid  = " + rs.getInt(1) + "");
                pst.executeUpdate();
                return true;

            } else {

                return false;

            }

        } catch (SQLException e) {
            System.out.println("Caught exception: " + e);
            return false;
        }

    }

    // Updates supplier.
    public static boolean updateSupplier(Supplier supplier) {
        try {
            connect_db();
            PreparedStatement pst = conn.prepareStatement("SELECT supplierid FROM suppliers WHERE name = '" + supplier.getName() + "'");
            rs = pst.executeQuery();

            if (rs.next()) {

                pst = conn.prepareStatement("UPDATE suppliers (name,email,number,address,varstatus) VALUES (?, ?, ?, ?, ?) WHERE supplierid = " + rs.getString(1) + "");
                pst.setString(1, supplier.getName());
                pst.setString(2, supplier.getEmail());
                pst.setString(3, supplier.getNumber());
                pst.setString(4, supplier.getAddress());
                pst.setBoolean(5, supplier.isVatstatus());
                pst.executeUpdate();
                return true;

            } else {

                return false;

            }

        } catch (SQLException e) {
            System.out.println("Caught exception: " + e);
            return false;
        }

    }

    public static boolean updateOrder(int orderid) {

        try {
            connect_db();
            PreparedStatement pst = conn.prepareStatement("UPDATE orders SET paid = (?) WHERE order_id = " + orderid + "");
            pst.setInt(1, 1);
            pst.executeUpdate();
            return true;

        } catch (SQLException e) {

            System.out.println("Caught exception: " + e);
            return false;
        }

    }

    public static boolean updateOrderQuantity(int itemid, int quantity) {

        try {
            connect_db();
            PreparedStatement selectpst = conn.prepareStatement("SELECT quantity FROM items WHERE itemid = " + itemid + "");
            rs = selectpst.executeQuery();
            int totalquantity = quantity;
            if (rs.next()) {
                totalquantity = rs.getInt("quantity") - quantity;
            }

            PreparedStatement pst = conn.prepareStatement("UPDATE items SET quantity = (?) WHERE itemid = " + itemid + "");
            pst.setInt(1, totalquantity);
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
        } catch (SQLException | ClassNotFoundException e) {
            System.out.print("Could not connect connect to the database. - Error:" + e);
        }
    }

}
