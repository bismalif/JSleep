package com.BismaAlifAlghifariJSleepMN;


import com.BismaAlifAlghifariJSleepMN.dbjson.Serializable;

import java.util.Date;

public class Invoice extends Serializable {
    public int buyerId;
    public int renterId;

    public PaymentStatus status;
    public RoomRating rating;

    public enum RoomRating{
        NONE,BAD,
        NEUTRAL,GOOD
    }

    public enum PaymentStatus{
        FAILED,WAITING,
        SUCCESS
    }

    protected Invoice(int buyerId, int renterId){
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
        this.buyerId = buyerId;
        this.renterId = renterId;

    }

    public Invoice(Account buyer, Renter renter) {
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
        this.buyerId = buyer.id;
        this.renterId = renter.id;

    }

    public String print(){
        return  "Id : " + this.id + " " +
                "Buyer Id : " + this.buyerId + " " +
                "Renter Id : " + this.renterId + " ";
    }


}
