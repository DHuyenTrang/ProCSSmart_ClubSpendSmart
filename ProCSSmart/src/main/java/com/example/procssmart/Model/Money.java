package com.example.procssmart.Model;

import java.io.Serializable;

public class Money implements Serializable {
    private String content, date, type, value;
    public Money(String content, String type, String date, String value) {
        this.content = content;
        this.value = value;
        this.date = date;
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
