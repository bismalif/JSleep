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
        Room test = createRoom();
        System.out.println(test.name);
        System.out.println(test.size);
        System.out.println(test.price.price);
        System.out.println(test.facility);
    }

    public static Room createRoom(){
        Price price = new Price(100000, 5);
        Room room = new Room("hotel", 30, price, Facility.AC);
        return room;
    }


}

