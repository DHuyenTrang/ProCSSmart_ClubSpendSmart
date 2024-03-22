package com.example.procssmart.Controller;

import com.example.procssmart.Model.Money;

import java.io.*;

public class AddIncome {
    public void perform (Money income){
        try {
            File file = new File("C:\\Users\\huyen\\Documents\\GitHub\\ProCSSmart_ClubSpendSmart\\ProCSSmart\\src\\main\\Data\\DataIncome.txt");
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(income);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        Money tmp = new Money("abc", 1000, "01/05/2024", "an");
//        AddIncome add = new AddIncome();
//        add.perform(tmp);
//    }
}
