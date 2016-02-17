package com.alekseysamoylov.banki.service;

/**
 * Created by alekseysamoylov on 2/17/16.
 */
public class StaticValues {
    public static int getBankId() {
        return bankId;
    }

    public static void setBankId(int bankId) {
        StaticValues.bankId = bankId;
    }

    private static int bankId;
    private static int clientId;
    private static int depositId;

    public static int getDepositId() {
        return depositId;
    }

    public static void setDepositId(int depositId) {
        StaticValues.depositId = depositId;
    }

    public static int getClientId() {
        return clientId;
    }

    public static void setClientId(int clientId) {
        StaticValues.clientId = clientId;
    }
}
