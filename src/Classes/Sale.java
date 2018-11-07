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
public class Sale {

    private String dateofsale;
    private int price;
    private int quantity;
    private String itemName;

    public Sale() {
    }

    public Sale(String dateofsale, int price, int quantity, String itemName) {
        this.dateofsale = dateofsale;
        this.price = price;
        this.quantity = quantity;
        this.itemName = itemName;
    }

    public String getDateofsale() {
        return dateofsale;
    }

    public void setDateofsale(String dateofsale) {
        this.dateofsale = dateofsale;
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

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

}
