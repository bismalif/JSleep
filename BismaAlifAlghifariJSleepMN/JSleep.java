package BismaAlifAlghifariJSleepMN;
import java.util.Scanner;

/**
 * Bisma Alif Alghifari
 * 2106731402
 * Modul 2
 */

public class JSleep
{

    public static void main(String[] args){
        Payment testRoom = new Payment(1, 1, 1, "", 1, "", "");
        Invoice testInvoice = new Invoice(2,2,2, "");
        System.out.println(testRoom.print());
        System.out.println(testInvoice.print());
    }


}

