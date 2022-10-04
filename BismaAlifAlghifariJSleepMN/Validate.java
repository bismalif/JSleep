package BismaAlifAlghifariJSleepMN;


/**
 * Write a description of class Validate here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
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
