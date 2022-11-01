package BismaAlifAlghifariJSleepMN;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.sql.Date;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.regex.*;

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
        Renter testregex = new Renter("Netlab_", "081234567890", "Jl Margonda Raya");
        Renter testregexFail = new Renter("Netlab", "081", "Jalan");
        System.out.println(testregex.validate());
        System.out.println(testregexFail.validate());

    }

    public static List<Room> filterByCity(List<Room> list, String search, int page, int pageSize){

        List<Room> filterlist = new ArrayList<Room>();
        for(Room entry : list){
            if(entry.name.toLowerCase().contains(search.toLowerCase())){
                filterlist.add(entry);
            }
        }
        return Algorithm.paginate(filterlist, page, pageSize, (e) -> Objects.equals(e.name, search));
    }

    public static List<Room> filterByPrice(List<Room> list, double min, double max){
        return Algorithm.<Room>collect(list,room -> room.price.price >= min && room.price.price <= max);
    }

    public static List<Room> filterByAccountId(List<Room> list, int accountId, int page, int pageSize){
        Predicate<Room> predicate = x -> (x.accountId == accountId);
        return Algorithm.paginate(list, page, pageSize, predicate);
    }

}
