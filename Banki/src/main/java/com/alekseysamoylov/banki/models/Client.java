package com.alekseysamoylov.banki.models;

/**
 * Created by alekseysamoylov on 2/16/16.
 */
public class Client {
    private int clientId;
    private String name;
    private String shortName;
    private String adress;
    private String form;

    public Client(int clientId, String name, String shortName, String adress, String form) {
        this.clientId = clientId;
        this.name = name;
        this.shortName = shortName;
        this.adress = adress;
        this.form = form;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }
}
