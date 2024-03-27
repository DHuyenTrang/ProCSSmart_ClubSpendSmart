package com.example.procssmart.Controller;

import com.example.procssmart.Model.Money;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AddMoney {
    public void add(Money money){
        File file = new File("C:\\Users\\huyen\\Documents\\GitHub\\ProCSSmart_ClubSpendSmart\\ProCSSmart\\src\\main\\Data\\dataMoney.txt");

        FileWriter writer = null;
        try {
            writer = new FileWriter(file, true);

            writer.write(money.getContent() + "\n");
            writer.write(money.getType() + "\n");
            writer.write(money.getDate() + "\n");
            writer.write(money.getValue() + "\n");

            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//    public static void main(String[] args) {
//        Money money1 = new Money("abc", "def", "01052004", "165843");
//        Money money2 = new Money("abcfs", "deffa", "01052dsaa004", "16vdvs5843");
//
//        AddMoney addMoney = new AddMoney();
//        addMoney.add(money1);
//        addMoney.add(money2);
//    }
}
