package com.BismaAlifAlghifariJSleepMN;


import com.BismaAlifAlghifariJSleepMN.dbjson.Serializable;

import java.util.Date;

/**
 * This class is used to store the payment information
 * of a transaction.
 * @author Bisma Alif Alghifari
 * @version 1.0
 * @since 2019-05-14
 */
public class Invoice extends Serializable {
    public int buyerId;
    public int renterId;

    public PaymentStatus status;
    public RoomRating rating;



    public enum RoomRating{
        NONE,BAD,
        NEUTRAL,GOOD
    }

    /**
     * This enum represents the status of a payment.
     * It can be either PAID, UNPAID, or CANCELLED.
     * @author Bisma Alif Alghifari
     * @version 1.0
     */
    public enum PaymentStatus{
        FAILED,WAITING,
        SUCCESS
    }

    /**
     * This constructor is used to create a new Invoice object.
     * @param buyerId The id of the customer who made the transaction.
     * @param renterId The id of the hotel that the customer made the transaction with.
     */
    protected Invoice(int buyerId, int renterId){
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
        this.buyerId = buyerId;
        this.renterId = renterId;

    }
    /**
     * This method is used to change the status of a payment.
     */
    public Invoice(Account buyer, Renter renter) {
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
        this.buyerId = buyer.id;
        this.renterId = renter.id;

    }

    /*
     * This method is used to change the status of a payment.
     */
    public String print(){
        return  "Id : " + this.id + " " +
                "Buyer Id : " + this.buyerId + " " +
                "Renter Id : " + this.renterId + " ";
    }


}
