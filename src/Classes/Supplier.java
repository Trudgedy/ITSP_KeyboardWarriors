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
public class Supplier {

    private int supplierid;
    private String name;
    private String email;
    private String number;
    private String address;
    private boolean vatstatus;

    // FOR ANDREW.
    public Supplier() {
    }

    // FOR ANDREW.
    public Supplier(int supplierid, String name, String email, String number, String address, boolean vatstatus) {
        this.supplierid = supplierid;
        this.name = name;
        this.email = email;
        this.number = number;
        this.address = address;
        this.vatstatus = vatstatus;
    }

    public int getSupplierid() {
        return supplierid;
    }

    public void setSupplierid(int supplierid) {
        this.supplierid = supplierid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isVatstatus() {
        return vatstatus;
    }

    public void setVatstatus(boolean vatstatus) {
        this.vatstatus = vatstatus;
    }

}
