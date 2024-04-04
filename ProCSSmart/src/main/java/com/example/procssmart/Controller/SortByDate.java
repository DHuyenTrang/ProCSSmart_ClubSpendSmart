package com.example.procssmart.Controller;

import com.example.procssmart.Model.Money;

import java.util.Comparator;

public class SortByDate implements Comparator<Money> {
    @Override
    public int compare(Money o1, Money o2) {
        String s1 = o1.getDate();
        String s2 = o2.getDate();

        return s1.compareTo(s2);
    }
}
