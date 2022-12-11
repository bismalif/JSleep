package com.BismaAlifAlghifariJSleepMN;


import com.BismaAlifAlghifariJSleepMN.dbjson.Serializable;
/**
 * This class represents a complaint made by a customer about a hotel.
 *
 * @author Bisma Alif Alghifari
 * @version 1.0
 * @since 29 September 2022
 * @see Serializable
 */
public class Complaint extends Serializable {
    public String desc;
    public String date;

    /**
     * Constructs a new Complaint.
     *
     * @param date The date to make a complaint.
     * @param desc The discount that will be applied to the original price
     */
    public Complaint(String date, String desc) {

        this.desc = desc;
        this.date = date;
    }

    /**
     * This method is used to show the date and description of a complaint.
     *
     * @return String of date and description
     */
    public String toString(){
        return "Id :" + id +
                "\nDesc : " + desc +
                "\nDate : " + date + "\n\n";
    }

}

