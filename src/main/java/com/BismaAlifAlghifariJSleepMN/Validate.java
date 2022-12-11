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
     * Filters an array of `Price` objects based on the specified value and condition.
     *
     * @param list  The array of `Price` objects to be filtered.
     * @param value  The value to compare against the prices in the array.
     * @param less  A boolean value indicating whether to filter prices less than or greater than the specified value.
     * @return  An `ArrayList` containing the filtered prices.
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
