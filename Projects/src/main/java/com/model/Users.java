package com.model;

import java.io.Serializable;

public class Users implements Serializable {
    int sl_no;
    String name;
    String email;
    long credits;

    long creditAmount;
    long creditToSend;
    String toUser;

    public Users() {

    }

    public Users(int sl_no, String name, String email, long credits){
        this.sl_no = sl_no;
        this.name = name;
        this.email= email;
        this.credits = credits;
    }

    public int getSl_no() {
        return sl_no;
    }

    public void setSl_no(int sl_no) {
        this.sl_no = sl_no;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getCredits() {
        return credits;
    }

    public void setCredits(long credits) {
        this.credits = credits;
    }

    public long getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(long creditAmount) {
        this.creditAmount = creditAmount;
    }

    public long getCreditToSend() {
        return creditToSend;
    }

    public void setCreditToSend(long creditToSend) {
        this.creditToSend = creditToSend;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }


}

