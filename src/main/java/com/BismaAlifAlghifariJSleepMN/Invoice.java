package com.BismaAlifAlghifariJSleepMN;


import com.BismaAlifAlghifariJSleepMN.dbjson.Serializable;

import java.util.Date;

/**
 * This class is used to store the payment information
 * of a transaction.
 * @author Bisma Alif Alghifari
 * @version 1.0
 * @since 27-09-2022
 * @see Serializable
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
     * Constructs a new Invoice.
     *
     * @param buyerId The account that makes a booking
     * @param renterId The renter that provides the room
     */
    protected Invoice(int buyerId, int renterId){
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
        this.buyerId = buyerId;
        this.renterId = renterId;

    }
    /**
     * Constructs a new Invoice.
     *
     * @param buyer The account that makes a booking
     * @param renter The renter that provides the room
     */
    public Invoice(Account buyer, Renter renter) {
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
        this.buyerId = buyer.id;
        this.renterId = renter.id;

    }

    /**
     * This method is used to show the date and description of a complaint.
     *
     * @return String of Invoice ID, Buyer ID, Renter ID, Payment Status, and Rating
     */
    public String print(){
        return  "Id : " + this.id + " " +
                "Buyer Id : " + this.buyerId + " " +
                "Renter Id : " + this.renterId + " ";
    }


}
