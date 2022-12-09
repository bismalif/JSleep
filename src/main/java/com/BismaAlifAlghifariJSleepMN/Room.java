package com.BismaAlifAlghifariJSleepMN;


import com.BismaAlifAlghifariJSleepMN.dbjson.Serializable;

import java.util.ArrayList;
import java.util.Date;

public class Room extends Serializable {
    public int size;
    public String name;
    public ArrayList<Facility> facility = new ArrayList<>();
    public Price price;
    public String address;
    public BedType bedType;
    public City city;
    public ArrayList<Date> booked;

    public int accountId;


    public Room(int accountId, String name, int size, Price price,
                ArrayList<Facility> facility, City city, String address, BedType bedType) {
        this.accountId = accountId;
        this.city = city;
        this.address = address;
        this.name = name;
        this.size = size;
        this.price = price;
        this.facility.addAll(facility);
        this.booked = new ArrayList<Date>();
        this.bedType = bedType;
    }

    public String toString(){
        return  "\nName : " + name +
                "\nBed Type : " + bedType +
                "\nSize : " + size +
                "\n" + price +
                "\nFacility : " + facility +
                "\nCity : " + city +
                "\nAddress : " + address +
                "\nId : " + id + "\n\n";
    }


}

