package com.gft.entities;

/**
 * Created by dplichta on 2015-08-05.
 */
import java.util.Date;

public class TransactionEntity {
    private int ID;
    private Date date;
    private double amount;
    private int accountId;


    public int getID() {
        return ID;
    }
    public void setID(int iD) {
        ID = iD;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public int getAccountId() {
        return accountId;
    }
    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }


}

