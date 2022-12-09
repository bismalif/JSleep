package com.BismaAlifAlghifariJSleepMN;



import java.util.ArrayList;

/**
 * This class represents an Account.
 *
 * @author Bisma Alif Alghifari
 * @version 1.0
 */
public class Validate {

    /**
     * This method is used to get the average rating of a hotel.
     * @return The average rating of a hotel.
     */
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
