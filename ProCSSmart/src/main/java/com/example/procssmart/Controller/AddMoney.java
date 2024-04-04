package com.example.procssmart.Controller;

import com.example.procssmart.Model.Money;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AddMoney {
    public void addIncome(Money money, boolean append) {
        File file = new File("C:\\Users\\huyen\\Documents\\GitHub\\ProCSSmart_ClubSpendSmart\\ProCSSmart\\src\\main\\resources\\com\\example\\procssmart\\dataIncome.txt");

        FileWriter writer = null;
        try {
            writer = new FileWriter(file, append);

            writer.write(money.getContent() + "\n");
            writer.write(money.getType() + "\n");
            writer.write(money.getDate() + "\n");
            writer.write(money.getValue() + "\n");

            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addPayment(Money money, boolean append) {
        File file = new File("C:\\Users\\huyen\\Documents\\GitHub\\ProCSSmart_ClubSpendSmart\\ProCSSmart\\src\\main\\resources\\com\\example\\procssmart\\dataPayment.txt");

        FileWriter writer = null;
        try {
            writer = new FileWriter(file, append);

            writer.write(money.getContent() + "\n");
            writer.write(money.getType() + "\n");
            writer.write(money.getDate() + "\n");
            writer.write(money.getValue() + "\n");

            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
