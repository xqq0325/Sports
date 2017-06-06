package com.xuqianqian.zjgsu.sports;

/**
 * Created by z on 2017/6/3.
 */

public class ChatMsg {
    private  String  name;
    private  String  date;
    private  String text;
    private  int layoutID;
    public ChatMsg(String name, String date, String  text, int id) {
        this.name=  name;
        this.date = date;
        this.text =text;
        this.layoutID = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public int getLayoutID() {
        return layoutID;
    }
    public void setLayoutID(int layoutID) {
        this.layoutID = layoutID;
    }

}

