package com.alekseysamoylov.banki.models;

/**
 * Created by alekseysamoylov on 2/17/16.
 */
public class Bank {
    private int bankId;
    private String name;
    private int bik;

    public Bank(int bankId, String name, int bik) {
        this.bankId = bankId;
        this.name = name;
        this.bik = bik;
    }

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBik() {
        return bik;
    }

    public void setBik(int bik) {
        this.bik = bik;
    }


}
