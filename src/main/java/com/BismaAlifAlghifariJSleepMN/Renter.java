package com.BismaAlifAlghifariJSleepMN;


import com.BismaAlifAlghifariJSleepMN.dbjson.Serializable;

import java.util.regex.*;

/**
 * This class represents an Account.
 *
 * @author Bisma Alif Alghifari
 * @version 1.0
 */
public class Renter extends Serializable {
    public String phoneNumber;
    public String address;
    public String username;

    public static final String REGEX_PHONE = "^[0-9]{9,12}$";
    public static final String REGEX_NAME = "^[A-Z]{1}\\w{4,20}$";

    /**
     * This constructor is used to create a new Renter object.
     * @param phoneNumber The phone number of the renter.
     * @param address The address of the renter.
     * @param username The username of the renter.
     */
    public Renter(String username, String address, String phoneNumber ){

        this.username = username;
        this.phoneNumber = phoneNumber;
        this.address = address;

    }

    /**
     * This method is used to get the phone number of the renter.
     * @return The phone number of the renter.
     */
    public boolean validate (){

        Pattern namePattern = Pattern.compile(REGEX_NAME);
        Matcher nameMatcher = namePattern.matcher(username);
        Pattern phonePattern = Pattern.compile(REGEX_PHONE);
        Matcher phoneMatcher = phonePattern.matcher(phoneNumber);

        return nameMatcher.find() && phoneMatcher.find();

    }



}

