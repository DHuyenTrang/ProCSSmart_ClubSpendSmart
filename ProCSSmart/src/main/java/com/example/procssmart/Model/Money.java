package com.example.procssmart.Model;

import java.io.Serializable;

public class Money implements Serializable {
    private String content, date, type;
    int value;

    public Money(String content, int value, String date, String type) {
        this.content = content;
        this.value = value;
        this.date = date;
        this.type = type;
    }

}
