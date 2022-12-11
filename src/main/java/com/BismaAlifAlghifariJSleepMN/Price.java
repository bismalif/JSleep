package com.BismaAlifAlghifariJSleepMN;

/**
 * This class represents a price for a product or service.
 *
 * <p>The price can have a discount applied to it, and a rebate can be provided as well.</p>
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
     * Constructs a new Price instance with the given base price and discount.
     *
     * @param price The base price of the room
     * @param discount The discount that will be applied to the original price
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