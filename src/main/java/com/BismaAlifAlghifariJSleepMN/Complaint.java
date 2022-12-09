package com.BismaAlifAlghifariJSleepMN;


import com.BismaAlifAlghifariJSleepMN.dbjson.Serializable;
/**
 * This class represents a complaint made by a customer about a hotel.
 *
 * @author Bisma Alif Alghifari
 * @version 1.0
 */
public class Complaint extends Serializable {
    public String desc;
    public String date;

    public Complaint(String date, String desc) {

        this.desc = desc;
        this.date = date;
    }

    public String toString(){
        return "Id :" + id +
                "\nDesc : " + desc +
                "\nDate : " + date + "\n\n";
    }

}

