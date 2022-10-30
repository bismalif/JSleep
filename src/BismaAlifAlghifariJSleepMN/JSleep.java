package BismaAlifAlghifariJSleepMN;

import java.util.ArrayList;
import java.util.Scanner;
import java.sql.Date;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import com.google.gson.*;

/**
 * Bisma Alif Alghifari
 * 2106731402
 * Modul 2
 */



public class JSleep {

    class Country{
        public String name;
        public String population;
        public List<String> listOfStates;
    }

    public static void main(String[] args) {
        String filepath = "C:\\Users\\Alghiy\\Documents\\Kuliah\\Semester 3\\OOP\\JSleep\\src\\city.json";
        Gson gson = new Gson();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            Country input = gson.fromJson(br, Country.class);
            System.out.println("name : " + input.name);
            System.out.println("population : " + input.population);
            System.out.println("states :");
            input.listOfStates.forEach(state -> System.out.println(state));
        } catch (IOException e) {
            e.printStackTrace();

//         ArrayList<Room> RoomSerialized = new ArrayList<Room>();
//         for (int i = 0; i < 5; i++) {
//             RoomSerialized.add(i, JSleep.createRoom());
//             System.out.println(RoomSerialized.get(i).toString());
        }
//         ArrayList<Room> RoomSerialized = new ArrayList<Room>();
//         for (int i = 0; i < 5; i++) {
//         RoomSerialized.add(i, JSleep.createRoom());
//         System.out.println(RoomSerialized.get(i).toString());
    }

//    public static Room createRoom() {
//        Price price = new Price(100000.0, 5);
//        Room room = new Room( "Hotel", 30, price,
//                Facility.AC, City.DEPOK, "Jalan Margonda Raya");
//        return room;
//    }


}
