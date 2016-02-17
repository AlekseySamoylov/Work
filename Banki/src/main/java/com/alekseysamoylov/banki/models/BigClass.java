package com.alekseysamoylov.banki.models;

import com.alekseysamoylov.banki.Store.BankListData;
import com.alekseysamoylov.banki.Store.ClientListData;

/**
 * Created by alekseysamoylov on 2/17/16.
 */
public class BigClass {

    private ClientListData clientListData;
    private BankListData bankListData;
    private Deposit deposit;


    public ClientListData getClientListData() {
        return clientListData = new ClientListData();
    }

    public void setClientListData(ClientListData clientListData) {
        this.clientListData = clientListData;
    }

    public BankListData getBankListData() {
        return bankListData = new BankListData();
    }

    public void setBankListData(BankListData bankListData) {
        this.bankListData = bankListData;
    }

    public Deposit getDeposit() {
        return deposit;
    }

    public void setDeposit(Deposit deposit) {
        this.deposit = deposit;
    }


    public BigClass(Deposit deposit) {
        this.deposit = deposit;
        this.clientListData = new ClientListData();
        this.bankListData = new BankListData();
    }

    public BigClass() {
        this.clientListData = new ClientListData();
        this.bankListData = new BankListData();
    }
}
