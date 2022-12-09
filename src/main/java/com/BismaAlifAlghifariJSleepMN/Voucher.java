package com.BismaAlifAlghifariJSleepMN;


import com.BismaAlifAlghifariJSleepMN.dbjson.Serializable;

/**
 * This class represents an Account.
 *
 * @author Bisma Alif Alghifari
 * @version 1.0
 */
public class Voucher extends Serializable {

    public Type type;
    public double cut;
    public String name;
    public int code;
    public double minimum;
    private boolean used;

    /**
     * This constructor is used to create a new Account object.
     * @param name The name of the account.
     * @param code The code of the account.
     * @param minimum The minimum of the account.
     * @param type The type of the account.
     * @param cut The cut of the account.
     */
    public Voucher(String name, int code, Type type, boolean used, double
            minimum, double cut)
    {
        this.name = name;
        this.type = type;
        this.cut = cut;
        this.code = code;
        this.minimum = minimum;
        this.used = false;
    }

    /**
     * This method is used to get the name of the account.
     * @return The name of the account.
     */
    public boolean canApply(Price price){
        if((price.price > minimum) && (!this.used)){
            return true;
        } return false;
    }

    /**
     * This method is used to get the name of the account.
     * @return The name of the account.
     */
    public double apply(Price price){
        used = true;
        if (this.type == Type.DISCOUNT){
            if (cut > 100){
                cut = 100;
            } return price.price - (price.price * (cut/100));
        }else{
            if (cut > 100){
                cut = price.price;
            } return price.price - cut;
        }
    }

    /**
     * This method is used to get the name of the account.
     * @return The name of the account.
     */
    public boolean isUsed(){
        return used = true;
    }
    

}

