package com.alekseysamlylov.magnitapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Created by Aleksey Samoylov on 14.01.2016.
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        try {
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Введите данные для подключения к Oracle Database Пример: jdbc:oracle:thin:@172.20.10.7:1521:xe");
            DataBaseConnection.setConnectionPath(bufferRead.readLine());
            System.out.println("Введите имя пользователя Oracle Database Пример: alekseysamoylov");
            DataBaseConnection.setLogin(bufferRead.readLine());
            System.out.println("Введите пароль пользователя Oracle Database Пример: 111111111");
            DataBaseConnection.setPassword(bufferRead.readLine());
            System.out.println("Введите число и засекайте время. Пример: 1000000");
            DataBaseConnection.setN(Integer.parseInt(bufferRead.readLine()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        new DataBaseConnection().doThisExersizes2();


    }
}
