package com.model;

import java.io.Serializable;

public class Transfer implements Serializable {
    String credit_from;
    String credit_to;
    long transferred_amt;

    public Transfer(){

    }

    public Transfer( String credit_from, String credit_to, long transferred_amt){
        this.credit_from = credit_from;
        this.credit_to = credit_to;
        this.transferred_amt = transferred_amt;
    }


    public String getCredit_from() {
        return credit_from;
    }

    public String getCredit_to() {
        return credit_to;
    }

    public void setCredit_to(String credit_to) {

        this.credit_to = credit_to;
    }

    public long getTransferred_amt() {

        return transferred_amt;
    }

    public void setTransfered_amount(long transferred_amt) {

        this.transferred_amt = transferred_amt;
    }
}
