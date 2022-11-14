package com.BismaAlifAlghifariJSleepMN;
import com.BismaAlifAlghifariJSleepMN.dbjson.JsonDBEngine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Bisma Alif Alghifari
 * 2106731402
 * Modul 2
 */


@SpringBootApplication
public class JSleep {


//    class Country{
//        public String name;
//        public String population;
//        public List<String> listOfStates;
//    }

    public static void main(String[] args) {
//        SpringApplication.run(JSleep.class, args);
//
//        Account testRegex = new Account("Netlab_", "bisma@gmail.com", "JokiNaufalFaza88");
//        Account testRegexFail = new Account("A", "bisma.alif@ui.ac.id", "JokiMelchiorNathan");
//        System.out.println(testRegex.validate());
//        System.out.println(testRegexFail.validate());
//
//        try {
//            String filepath = "src\\json\\account.json";
//            JsonTable<Account> tableAccount = new JsonTable<Account>(Account.class, filepath);
//            tableAccount.add(new Account("Name", "Email", "Password"));
//            tableAccount.writeJson();
//
//            tableAccount = new JsonTable<Account>(Account.class, filepath);
//            tableAccount.forEach(acc -> System.out.println(acc.toString()));
//
//        } catch (Throwable t) {
//            t.printStackTrace();
//        }
        JsonDBEngine.Run(JSleep.class);
        SpringApplication.run(JSleep.class, args);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> JsonDBEngine.join()));

    }

//    public static Room createRoom(){
//        Price price = new Price(100000.0,5);
//        return new Room(2,"Restaurant",30,price,Facility.AC,City.JAKARTA,"Jl.Medan");
//    }


//
//    public static List<Room> filterByCity(List <Room> list , String search, int page, int pageSize){
//        return Algorithm.paginate(list, page, pageSize, room -> room.city.toString().toLowerCase().contains(search.toLowerCase()));
//    }
//
//    public static List<Room> filterByPrice(List<Room> priceList, double minPrice, double maxPrice){
//        if(maxPrice == 0){
//            return Algorithm.<Room>collect(priceList, temp -> (temp.price.price >= minPrice));
//        }
//        return Algorithm.<Room>collect(priceList, temp -> (temp.price.price <= maxPrice) && (temp.price.price >= minPrice));
//    }
//
//    public static List<Room>  filterByAccountId(List <Room> list , int accountId, int page, int pageSize){
//        ArrayList<Room> accountIdResult = new ArrayList<>();
//        return Algorithm.paginate(list, page, pageSize, id -> id.accountId == accountId);
//    }

}
