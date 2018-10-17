/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author hamme
 */
public class Order {

    private String date;
    private String businessname;
    private String item;
    private int amount;
    private int itemid;
    private boolean paid;
    private int orderid;
    private int quantity;

    // FOR ANDREW.
    public Order() {
    }

    // FOR ANDREW.
    public Order(String date, String businessname, String item, int amount, int itemid, boolean paid, int orderid, int quantity) {
        this.date = date;
        this.businessname = businessname;
        this.item = item;
        this.amount = amount;
        this.itemid = itemid;
        this.paid = paid;
        this.orderid = orderid;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getBusinessname() {
        return businessname;
    }

    public void setBusinessname(String businessname) {
        this.businessname = businessname;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getItemid() {
        return itemid;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

}
