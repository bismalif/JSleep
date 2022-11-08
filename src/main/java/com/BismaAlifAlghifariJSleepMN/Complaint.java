package com.BismaAlifAlghifariJSleepMN;


import com.BismaAlifAlghifariJSleepMN.dbjson.Serializable;

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

