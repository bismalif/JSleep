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
     * Constructs a new Payment.
     *
     * @param buyer The account that makes a booking
     * @param renter The renter that provides the room
     * @param from The start date of a booking
     * @param to The end date of a booking
     */
    public Payment(Account buyer, Renter renter, int roomId, Date
            from, Date to) {
        super(buyer, renter);
        this.to = to;
        this.from = from;
        this.roomId = roomId;
    }


    /**
     * Checks whether a room is available to be booked within the given date range.
     *
     * @param from The start date of the booking
     * @param to The end date of the booking
     * @param room The Room to check availability for
     * @return true if the Room is available within the given date range, false otherwise
     */
    //Todo : logic for checking availability and booking
    public static boolean availability(Date from,Date to,Room room){
        if(from.after(to) || from.equals(to)){
            return false;
        }
        for (Date i : room.booked) {
            if (from.equals(i)) {
                return false;
            } else if(from.before(i)){
                if(from.before(i) && to.after(i)){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * This method checks the availability of a room for a given time period.
     *
     * @param from The start date of the booking period
     * @param to The end date of the booking period
     * @param room The room to be booked
     * @return true if the room is available for the given time period, false otherwise
     */
    public static boolean makeBooking(Date from,Date to,Room room){
        if(availability(from, to, room)){

            while (from.before(to)){
                room.booked.add(from); // Assign ke array
                Calendar tempVar = Calendar.getInstance();
                tempVar.setTime(from);
                tempVar.add(Calendar.DATE, 1); //Increment 1
                from = tempVar.getTime();
            }
            return true;
        }
        else{
            return false;
        }

    }

    /**
     * This method is used to show the date and description of a complaint.
     *
     * @return String of Buyer ID, Renter ID, Room ID, start and end date of booking
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
     * A method to get room ID for payment
     *
     * @return room ID
     */
    public int getRoomId(){
        return this.roomId;
    }


}