package BismaAlifAlghifariJSleepMN;
import java.util.Scanner;

/**
 * Bisma Alif Alghifari
 * 2106731402
 * Modul 2
 */

public class JSleep
{

   public static void main(String[] args) {
        Payment testPayment = new Payment(2, 2, 2, 2);
        System.out.println(testPayment.getTime());
        System.out.println(testPayment.getDuration());
        Price[] unfilteredArray = new Price[5];
        for (int i = 0; i < unfilteredArray.length; i++) {
            int j = 5000;
            unfilteredArray[i] = new Price((i + 1) * j);
        }
        System.out.println("Price List");
        for (int i = 0; i < unfilteredArray.length; i++) {
            System.out.println(unfilteredArray[i].price);
        }
        System.out.println("Below 12000.0");
        System.out.println(Validate.filter(unfilteredArray, 12000, true));
        System.out.println("Above 10000.0");
        System.out.println(Validate.filter(unfilteredArray, 10000, false));


    }
}

