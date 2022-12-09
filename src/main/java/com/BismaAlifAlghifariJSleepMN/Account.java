package com.BismaAlifAlghifariJSleepMN;

import com.BismaAlifAlghifariJSleepMN.dbjson.Serializable;

import java.util.regex.*;

public class Account extends Serializable {

    public double balance;
    public Renter renter;
    public String name;
    public String email;
    public String password;
    public static final String REGEX_EMAIL = "^[a-zA-Z0-9]+@[a-zA-Z.]+\\.[a-zA-Z]+?$";
    public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";

    /**
     * This is the constructor for the Account class.
     *
     * @param name The name of the Account.
     * @param email The email of the Account.
     * @param password The password of the Account.
     */
    public Account (String name, String email, String password)
    {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    /**
     * This method returns a string representation of the Account.
     *
     * @return The string representation of the Account.
     */
    public String toString(){
        return "Id : " + id +
                "\nName : " + name +
                "\nEmail : " + email +
                "\nPassword : " + password + "\n\n";
    }

    /**
     * This method validates the email and password fields of the Account.
     *
     * @return true if the email and password fields are valid, false otherwise.
     */
    public boolean validate(){
        Pattern emailPattern = Pattern.compile(REGEX_EMAIL);
        Matcher emailMatcher = emailPattern.matcher(email);
        Pattern passwordPattern = Pattern.compile(REGEX_PASSWORD);
        Matcher passwordMatcher = passwordPattern.matcher(password);

        return emailMatcher.find() && passwordMatcher.find();
    }

}
