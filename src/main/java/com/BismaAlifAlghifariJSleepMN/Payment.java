package com.BismaAlifAlghifariJSleepMN;



import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class represents a payment made by a customer.
 *
 * @author Bisma Alif Alghifari
 * @version 1.0
 */
public class Payment extends Invoice  {

    public Date to;
    public Date from;
    private int roomId;

    /**
     * This constructor is used to create a new Payment object.
     * @param buyerId The id of the customer who made the transaction.
     * @param renterId The id of the hotel that the customer made the transaction with.
     * @param roomId The id of the room that the customer made the transaction with.
     * @param from The date when the customer checked in.
     * @param to The date when the customer checked out.
     */
    public Payment(int buyerId, int renterId, int roomId, Date
            from, Date to) {
        super(buyerId, renterId);
        this.to = to;
        this.from = from;
        this.roomId = roomId;

    }

    /**
     * This method is used to change the status of a payment.
     */
    public Payment(Account buyer, Renter renter, int roomId, Date
            from, Date to) {
        super(buyer, renter);
        this.to = to;
        this.from = from;
        this.roomId = roomId;
    }


    /**
     * This method is used to get the total price of a payment.
     * @return The total price of a payment.
     */
    public static boolean availability(Date from,Date to,Room room){
        if (from.equals(to))
            return false;

        if(room.booked.isEmpty()) {
            return true;
        }

        for (Date i : room.booked) {
            if (from.equals(i) ) {
                return false;
            } else if(from.before(i) && to.after(i)){
                    return false;
            }
        }
        return true;


    }

    /**
     * This method is used to get the total price of a payment.
     * @return The total price of a payment.
     */
    public static boolean makeBooking(Date from,Date to,Room room){
        if(to.before(from))
            return false;


        if(availability(from, to, room)){
            while (from.before(to)){
                room.booked.add(from);
                Calendar c = Calendar.getInstance();
                c.setTime(from);
                c.add(Calendar.DATE, 1);
                from = c.getTime();
            }return true;

        }return false;

    }

    /**
     * This method is used to get the total price of a payment.
     * @return The total price of a payment.
     */
    public String print() {
        return  "Id : " + id + " " +
                "Buyer Id : " + buyerId + " " +
                "Renter Id : " + renterId + " " +
                "Room Id : " + roomId + " " +
                "From : " + from + " " +
                "To : " + to + "\n\n";
    }

    /**
     * This method is used to get the total price of a payment.
     * @return The total price of a payment.
     */
    public int getRoomId(){
        return this.roomId;
    }


}