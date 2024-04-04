package com.example.procssmart.Model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadData {
    public  List<Money> readToList(){
        List<Money> moneyList = new ArrayList<Money>();

        File file = new File("C:\\Users\\huyen\\Documents\\GitHub\\ProCSSmart_ClubSpendSmart\\ProCSSmart\\src\\main\\Data\\dataMoney.txt");
        FileReader reader = null;
        try {
            reader = new FileReader(file);
            BufferedReader br = new BufferedReader(reader);
            while (br.ready()){
                String content = br.readLine();
                String type = br.readLine();
                String date = br.readLine();
                String value = br.readLine();

                Money money = new Money(content, type, date, value);
                moneyList.add(money);
            }

            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return moneyList;
    }

    public List<Money> readToListIn(){
        List<Money> moneyList = new ArrayList<Money>();

        File file = new File("C:\\Users\\huyen\\Documents\\GitHub\\ProCSSmart_ClubSpendSmart\\ProCSSmart\\src\\main\\resources\\com\\example\\procssmart\\dataIncome.txt");
        FileReader reader = null;
        try {
            reader = new FileReader(file);
            BufferedReader br = new BufferedReader(reader);
            while (br.ready()){
                String content = br.readLine();
                String type = br.readLine();
                String date = br.readLine();
                String value = br.readLine();

                Money money = new Money(content, type, date, value);
                moneyList.add(money);
            }

            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return moneyList;
    }

    public List<Money> readToListOut(){

        List<Money> moneyList = new ArrayList<Money>();

        File file = new File("C:\\Users\\huyen\\Documents\\GitHub\\ProCSSmart_ClubSpendSmart\\ProCSSmart\\src\\main\\resources\\com\\example\\procssmart\\dataPayment.txt");
        FileReader reader = null;
        try {
            reader = new FileReader(file);
            BufferedReader br = new BufferedReader(reader);
            while (br.ready()){
                String content = br.readLine();
                String type = br.readLine();
                String date = br.readLine();
                String value = br.readLine();

                Money money = new Money(content, type, date, value);
                moneyList.add(money);
            }

            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return moneyList;
    }
//
//    public static void main(String[] args) {
//        ReadData read = new ReadData();
//        List<Money> moneyList = read.readToList();
//        for (Money money:moneyList) {
//            System.out.println(money.getContent());
//        }
//        System.out.println(moneyList.size());
//    }
}
