package com.BismaAlifAlghifariJSleepMN.controller;

import com.BismaAlifAlghifariJSleepMN.Account;
import com.BismaAlifAlghifariJSleepMN.Algorithm;
import com.BismaAlifAlghifariJSleepMN.Renter;
import com.BismaAlifAlghifariJSleepMN.controller.BasicGetController;
import com.BismaAlifAlghifariJSleepMN.dbjson.JsonAutowired;
import com.BismaAlifAlghifariJSleepMN.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class represents an AccountController.
 *
 * @author Bisma Alif Alghifari
 * @version 1.0
 */
@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account>
{
    /**
     * Regex for the password. Password should be at least 8 characters long
     * and contain at least 1 uppercase letter, 1 lowercase letter, 1 number, and no whitespace
     */
    public static final String REGEX_EMAIL = "^[a-zA-Z0-9]+@[a-zA-Z.]+\\.[a-zA-Z]+?$";
    /**
     * Regex for the email. Email should be in the format of
     * in the format of local@domain, example : amandio@ui.ac.id
     * local only contains alphanumeric characters and can't contain
     * any special characters or whitespace. domain can't contain any number
     */
    public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";

    /**
     * Pattern for password and Email REGEX
     */
    public static final Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);
    public static final Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);
    /**
     * The table of accounts.
     */
    @JsonAutowired(value = Account.class,filepath = "src\\json\\account.json")
    public static JsonTable<Account> accountTable;

    @GetMapping
    String index() { return "account page"; }


    /**
     * This method is used to handle /account/login requests from the client.
     * @param email The email of the account.
     * @param password The password of the account.
     * @return The account that has the same email and password as the parameter.
     *         If the account doesn't exist, it will return null.
     * @author Bisma Alif Alghifari
     */
    @PostMapping("/login")
    Account login(
            @RequestParam String email,
            @RequestParam String password
    ){
        Account findAccount = Algorithm.<Account> find(getJsonTable(),pred -> pred.email.equals(email));

        final String generatedPassword = hashPassword(password);

        if (findAccount != null && generatedPassword.equals(findAccount.password)){
            return findAccount;
        }else{
            return null;
        }
    }

    /**
     * Register a new account to the system using the name, email and password.
     *
     * @param name The name the user wants to register.
     * @param email The email of the account.
     * @param password The password of the account.
     * @return The created `Account` object if the registration is successful, or `null` otherwise.
     */
    @PostMapping("/register")
    Account register(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String password
    ){

        Matcher matcherEmail = REGEX_PATTERN_EMAIL.matcher(email);
        boolean matchEmail = matcherEmail.find();

        Matcher matcherPassword = REGEX_PATTERN_PASSWORD.matcher(password);
        boolean matchFoundPassword = matcherPassword.find();

        Account findAccount = Algorithm.<Account> find(getJsonTable(),pred -> pred.email.equals(email));

        if (findAccount == null && matchEmail && matchFoundPassword) {
            final String generatedPassword;
            generatedPassword = hashPassword(password);
            Account account = new Account(name, email, generatedPassword);
            accountTable.add(account);
            return account;
        } return null;

    }


    /**
     * Registers a new renter for the specified account.
     *
     *  @param id The ID of the account.
     *  @param username The username of the renter.
     *  @param address The address of the renter.
     *  @param phoneNumber The phone number of the renter.
     *  @return The created `Renter` object if the registration is successful, or `null` otherwise.
     */
    @PostMapping("/{id}/registerRenter")
    Renter registerRenter(@PathVariable int id, @RequestParam String username, @RequestParam String address,
                          @RequestParam String phoneNumber ){

        Account temp = Algorithm.<Account>find(accountTable,pred -> pred.id == id);
        if(temp.renter == null && temp != null){
            temp.renter = new Renter(username, address, phoneNumber);
            return temp.renter;
        }
        else{
            return null;
        }
    }

    /**
     * This method is used to get the account of a user.
     * @param id The id of the account that will be topped up.
     * @param balance The amount of money that will be topped up.
     * @return true if the account has been topped up and false if the account doesn't exist.
     * @author Bisma Alif Alghifari
     */
    @PostMapping("/{id}/topUp")
    boolean topUp(@PathVariable int id, @RequestParam double balance ){
        Account account = Algorithm.<Account>find(accountTable, acc -> id == acc.id);
        if (account != null){
            account.balance += balance;
            return true;
        }else{
            return false;
        }
    }

    /**
     * Hashes the provided password using the MD5 algorithm.
     *
     * @param password The password to hash.
     * @return The hashed password.
     */
    String hashPassword(String password){
        String generatedPassword = null;
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte aByte : bytes) {
                sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        }catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return generatedPassword;
    }


    /**
     * Returns the `JsonTable` object that stores the accounts.
     *
     * @return The `JsonTable` object that stores the accounts.
     */
    @Override
    public JsonTable<Account> getJsonTable() {
        return accountTable;
    }


}
