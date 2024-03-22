package com.example.procssmart.Controller;

import com.example.procssmart.Model.Money;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class AddCost {
    public void perform(Money cost){
        try {
            File file = new File("C:\\Users\\huyen\\Documents\\GitHub\\ProCSSmart_ClubSpendSmart\\ProCSSmart\\src\\main\\Data\\DataCost.txt");
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(cost);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
