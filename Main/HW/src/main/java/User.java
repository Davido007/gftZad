/**
 * Created by dplichta on 2015-08-04.
 */

import java.util.ArrayList;

public class User {
    private String name;
    private String surname;
    private AccountData accData;
    private ArrayList<Transaction> transactions;

    public User() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public AccountData getAccData() {
        return this.accData;
    }

    public void setAccData(AccountData accData) {
        this.accData = accData;
    }

    public ArrayList<Transaction> getTransactions() {
        return this.transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }
}
