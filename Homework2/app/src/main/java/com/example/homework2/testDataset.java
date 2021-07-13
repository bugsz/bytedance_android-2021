package com.example.homework2;

import java.util.ArrayList;
import java.util.List;

public class testDataset {

    public static List<testData> getData() {
        List<testData> result = new ArrayList();
        result.add(new testData("让人忘记原唱的歌手", "524.6w"));
        result.add(new testData("林丹退役", "433.6w"));
        result.add(new testData("你在教我做事？", "357.8w"));
        result.add(new testData("投身乡村教育的燃灯者", "333.6w"));
        result.add(new testData("暑期嘉年华", "285.6w"));
        result.add(new testData("2020年三伏天有40天", "183.2w"));
        result.add(new testData("会跟游客合照的老虎", "139.4w"));
        result.add(new testData("苏州暴雨", "75.6w"));
        result.add(new testData("6月全国菜价上涨", "55w"));
        result.add(new testData("猫的第六感有多强", "43w"));
        result.add(new testData("IU真好看", "22.2w"));
        return result;
    }
}
