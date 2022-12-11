package com.BismaAlifAlghifariJSleepMN;


import com.BismaAlifAlghifariJSleepMN.dbjson.Serializable;

import java.util.ArrayList;
import java.util.Date;

/**
 * This class represents a room in a hotel.
 *
 * @author Bisma Alif Alghifari
 * @since 27 September 2022
 * @version 1.0
 */
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


    /**
     * Constructs a new `Room` object with the given parameters.
     *
     * @param accountId  The ID of the account that owns the room.
     * @param name       The name of the room.
     * @param size       The size of the room in square meters.
     * @param price      The price of the room.
     * @param facility   The facilities available in the room.
     * @param city       The city where the room is located.
     * @param address    The address of the room.
     * @param bedType    The type of bed in the room.
     */
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

    /**
     * Returns a string representation of the `Room` object.
     *
     * @return a string representation of the `Room` object.
     */
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

