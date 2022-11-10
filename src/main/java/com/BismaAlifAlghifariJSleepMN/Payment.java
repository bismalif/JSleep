package com.BismaAlifAlghifariJSleepMN;



import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Payment extends Invoice  {

    public Date to;
    public Date from;
    private int roomId;

    public Payment(int buyerId, int renterId, int roomId, Date
            from, Date to) {
        super(buyerId, renterId);
        this.to = to;
        this.from = from;
        this.roomId = roomId;

    }

    public Payment(Account buyer, Renter renter, int roomId, Date
            from, Date to) {
        super(buyer, renter);
        this.to = to;
        this.from = from;
        this.roomId = roomId;
    }


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

    public String print() {
        return  "Id : " + id + " " +
                "Buyer Id : " + buyerId + " " +
                "Renter Id : " + renterId + " " +
                "Room Id : " + roomId + " " +
                "From : " + from + " " +
                "To : " + to + "\n\n";
    }

    public int getRoomId(){
        return this.roomId;
    }


}