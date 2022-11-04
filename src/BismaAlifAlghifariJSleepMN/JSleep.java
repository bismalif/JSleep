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
        Account testRegex = new Account("Netlab_", "bisma@gmail.com", "JokiNaufalFaza88");
        Account testRegexFail = new Account("A", "bisma.alif@ui.ac.id", "JokiMelchiorNathan");
        System.out.println(testRegex.validate());
        System.out.println(testRegexFail.validate());

        try {
            String filepath = "src\\json\\account.json";
            JsonTable<Account> tableAccount = new JsonTable<Account>(Account.class, filepath);
            tableAccount.add(new Account("Name", "Email", "Password"));
            tableAccount.writeJson();

        } catch (Throwable t) {
            t.printStackTrace();
        }

        for(int i = 0; i < 10; i++) {
            ThreadingObject thread = new ThreadingObject("Thread " + i);
        }

    }



    public static List<Room> filterByCity(List <Room> list , String search, int page, int pageSize){
        return Algorithm.paginate(list, page, pageSize, room -> room.city.toString().toLowerCase().contains(search.toLowerCase()));
    }

    public static List<Room> filterByPrice(List<Room> priceList, double minPrice, double maxPrice){
        if(maxPrice == 0){
            return Algorithm.<Room>collect(priceList, temp -> (temp.price.price >= minPrice));
        }
        return Algorithm.<Room>collect(priceList, temp -> (temp.price.price <= maxPrice) && (temp.price.price >= minPrice));
    }

    public static List<Room>  filterByAccountId(List <Room> list , int accountId, int page, int pageSize){
        ArrayList<Room> accountIdResult = new ArrayList<>();
        return Algorithm.paginate(list, page, pageSize, id -> id.accountId == accountId);
    }


}
