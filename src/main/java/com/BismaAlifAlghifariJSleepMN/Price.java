package com.BismaAlifAlghifariJSleepMN;

/**
 * This enum represents the different types of beds that a hotel room can have.
 *
 * @author Bisma Alif Alghifari
 * @version 1.0
 */

public class Price {

    //public double rebate;
    public double price;
    public double discount;

    /**
     * This constructor is used to create a new Price object.
     * @param price The price of a room.
     */
    public Price(double price) {
        this.price = price;
        this.discount = 0;
    }

    /**
     * This method is used to get the price of a room.
     * @return The price of a room.
     */
    public Price(double price, double discount) {
        this.price = price;
        this.discount = discount;
    }

    /**
     * This method is used to get the price of a room.
     * @return The price of a room.
     */
    public String toString(){
        return  "Price : " + price;

    }

}