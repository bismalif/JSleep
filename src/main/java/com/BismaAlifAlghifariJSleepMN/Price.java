package com.BismaAlifAlghifariJSleepMN;


public class Price {

    //public double rebate;
    public double price;
    public double discount;


    public Price(double price) {
        this.price = price;
        this.discount = 0;
    }

    public Price(double price, double discount) {
        this.price = price;
        this.discount = discount;
    }

    public String toString(){
        return  "Price : " + price;

    }

/*
    public Price(double price, double rebate) {
        this.price = price;
        //this.rebate = rebate;
        this.discount = 0;
    }
*/

/*
    private double getDiscountedPrice() {
        if (discount >= 100.0) {
            return 0.0;
        } return price - (price * ((double)discount/100.0));

    }

    private double getRebatedPrice() {
        if (rebate > price){
            rebate = price;
        } return price - rebate;

    }
*/

}