package com.gft.com.gft.dto;

/**
 * Created by dplichta on 2015-08-06.
 */
public class AccountServiceDTO {
    private int ID;
    private String number;
    private double balance;
    private int userId;

    public int getID() {
        return ID;
    }
    public void setID(int iD) {
        ID = iD;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
}
