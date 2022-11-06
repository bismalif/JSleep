package com.BismaAlifAlghifariJSleepMN;


import java.util.regex.*;

public class Renter extends Serializable {
    public String phoneNumber;
    public String address;
    public String username;

    public static final String REGEX_PHONE = "^[0-9]{9,12}$";
    public static final String REGEX_NAME = "^[A-Z]{1}\\w{4,20}$";

    public Renter(String username, String phoneNumber, String address){

        this.username = username;
        this.phoneNumber = phoneNumber;
        this.address = address;

    }

    public boolean validate (){

        Pattern namePattern = Pattern.compile(REGEX_NAME);
        Matcher nameMatcher = namePattern.matcher(username);
        Pattern phonePattern = Pattern.compile(REGEX_PHONE);
        Matcher phoneMatcher = phonePattern.matcher(phoneNumber);

        return nameMatcher.find() && phoneMatcher.find();

    }



}

