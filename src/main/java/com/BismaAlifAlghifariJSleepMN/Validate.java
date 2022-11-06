package com.BismaAlifAlghifariJSleepMN;



import java.util.ArrayList;

public class Validate {

    public static ArrayList filter(Price[] list, int value, boolean less) {
        ArrayList<Double> val = new ArrayList<>();

        for (Price x : list) {
            if ((less == true && x.price <= value)) {
                val.add(x.price);
            } else if (less == false && x.price > value) {
                val.add(x.price);
            }


        }
        return val;
    }
}
