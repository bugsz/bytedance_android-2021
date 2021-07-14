package com.example.chapter3.homework;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class testDataset {

    public static List<testData> getData() {
        List<testData> result = new ArrayList();
        Date date = new Date();
        result.add(new testData("西瓜", "我不写作业了！", date));
        result.add(new testData("土豆", "李在干神魔", date));
        result.add(new testData("Charlie", "Android", date));
        result.add(new testData("Dave", "IOS", date));
        result.add(new testData("Eve", "Test", date));
        result.add(new testData("鞋套", "我要发paper了", date));
        result.add(new testData("Oscar", "Test Hello", date));
        result.add(new testData("Steve", "Test", date));
        return result;
    }
}
