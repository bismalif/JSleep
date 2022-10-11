package BismaAlifAlghifariJSleepMN;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Bisma Alif Alghifari
 * 2106731402
 * Modul 2
 */

import java.sql.Date;

public class JSleep {

    public static void main(String[] args) {
         ArrayList<Room> RoomSerialized = new ArrayList<Room>();
         for (int i = 0; i < 5; i++) {
             RoomSerialized.add(i, JSleep.createRoom());
             System.out.println(RoomSerialized.get(i).toString());
         }
    }

    public static Room createRoom() {
        Price price = new Price(100000.0, 5);
        Room room = new Room( "Restaurant", 30, price,
                Facility.AC, City.DEPOK, "Jalan Margonda Raya");
        return room;
    }
}
