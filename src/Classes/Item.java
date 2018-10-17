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
public class Item {

    private String itemName;
    private String supplierName;
    private int price;
    private int quantity;
    private int itemid;

    public Item() {

    }

    public Item(String itemName, String supplierName, int price, int quantity, int itemid) {
        this.itemName = itemName;
        this.supplierName = supplierName;
        this.price = price;
        this.quantity = quantity;
        this.itemid = itemid;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getItemid() {
        return itemid;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
    }

}
