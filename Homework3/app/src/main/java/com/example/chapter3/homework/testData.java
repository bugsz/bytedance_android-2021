package com.example.chapter3.homework;


import java.util.Date;
import java.util.Random;

public class testData {
    String Name;
    String Text;
    Date Time;
    int id;
    static int count = 0;
    static Random random = new Random(100);

    public testData(String Name, String Text, Date Time){
        this.Name = Name;
        this.Text = Text;
        this.Time = Time;
        count += 1;
        id = random.nextInt(100) % 3;
    }
}
