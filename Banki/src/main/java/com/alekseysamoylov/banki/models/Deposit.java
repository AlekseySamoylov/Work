package com.alekseysamoylov.banki.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by alekseysamoylov on 2/16/16.
 */
public class Deposit {

    int depositId;
    int clientId;
    int bankId;
    String clientShortName;
    String bankName;
    String dateTime;
    int percent;
    int creditTime;

    public Deposit(int depositId, int clientId, int bankId, String clientShortName, String bankName, String dateTime, int percent, int creditTime) {
        this.depositId = depositId;
        this.clientId = clientId;
        this.bankId = bankId;
        this.clientShortName = clientShortName;
        this.bankName = bankName;
        this.dateTime = dateTime;
        this.percent = percent;
        this.creditTime = creditTime;
    }

    public int getDepositId() {
        return depositId;
    }

    public void setDepositId(int depositId) {
        this.depositId = depositId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    public String getClientShortName() {
        return clientShortName;
    }

    public void setClientShortName(String clientShortName) {
        this.clientShortName = clientShortName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime){

        this.dateTime = dateTime;    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public int getCreditTime() {
        return creditTime;
    }

    public void setCreditTime(int creditTime) {
        this.creditTime = creditTime;
    }
}
