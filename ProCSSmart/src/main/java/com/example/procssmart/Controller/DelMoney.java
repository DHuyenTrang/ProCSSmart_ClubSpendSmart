package com.example.procssmart.Controller;

import com.example.procssmart.Model.Money;

import java.io.*;
import java.util.Objects;

public class DelMoney { // csv
    public void delete(Money money){
        File file = new File("C:\\Users\\huyen\\Documents\\GitHub\\ProCSSmart_ClubSpendSmart\\ProCSSmart\\src\\main\\Data\\dataMoney.txt");
        File newFile = new File("C:\\Users\\huyen\\Documents\\GitHub\\ProCSSmart_ClubSpendSmart\\ProCSSmart\\src\\main\\Data\\dataTmp.txt");

        BufferedReader reader = null;
        FileWriter writer = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            writer = new FileWriter(newFile);
            writer.write("hehehe");

//            BufferedWriter writer1 = new BufferedWriter(new FileWriter(file));
//            BufferedReader reader1 = new BufferedReader(new FileReader(newFile));
//            while(reader1.ready()){
//                writer1.write(reader1.readLine());
//            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
