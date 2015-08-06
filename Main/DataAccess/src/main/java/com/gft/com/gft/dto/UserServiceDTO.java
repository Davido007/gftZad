package com.gft.com.gft.dto;

/**
 * Created by dplichta on 2015-08-06.
 */
public class UserServiceDTO {
    private int ID;
    private String firstName;
    private String surname;

    public int getID() {
        return ID;
    }
    public void setID(int iD) {
        ID = iD;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
}
