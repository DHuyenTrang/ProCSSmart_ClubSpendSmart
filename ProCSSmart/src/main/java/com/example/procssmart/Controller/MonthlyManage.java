package com.example.procssmart.Controller;

import com.example.procssmart.Model.Money;
import com.example.procssmart.Model.ReadData;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MonthlyManage {
    MonthlyManage(){
        ReadData read = new ReadData();

        List<Money> moneyList = new ArrayList<>();
        moneyList.addAll(read.readToListIn());
        moneyList.addAll(read.readToListOut());

        moneyList.sort(new SortByDate());

        List<Integer> moneyCurrent = new ArrayList<>();
        moneyCurrent.add(0);
        int sum = Integer.parseInt(moneyList.getFirst().getValue());
        for(int i = 0; i < moneyList.size(); i++){
            Money money = moneyList.get(i);
            Money nextMoney = moneyList.get(i + 1);
            if(Objects.equals(money.getYear(), nextMoney.getYear()) && Objects.equals(money.getMonth(), nextMoney.getMonth())){
                
            }
        }
    }
}
