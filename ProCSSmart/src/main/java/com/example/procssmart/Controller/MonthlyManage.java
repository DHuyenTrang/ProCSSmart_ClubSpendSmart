package com.example.procssmart.Controller;

import com.example.procssmart.Model.Money;
import com.example.procssmart.Model.ReadData;

import java.util.List;
import java.util.Objects;

public class MonthlyManage {

    public int getValues(Money money){
        int value = Integer.parseInt(money.getValue());
        if(Objects.equals(money.getType(), "Tiền quỹ vào")) return value;
        return -value;
    }
    public int getMoneyCurrent(String time){
        ReadData read = new ReadData();
        List<Money> moneyList = read.readToList();

        moneyList.sort(new SortByDate());

        int sum = 0;

        for(Money money: moneyList){
            if(money.getMonthYear().compareTo(time) < 0) sum += getValues(money);
            else break;
        }
        return sum;
    }
}
