package BismaAlifAlghifariJSleepMN;


/**
 * Write a description of class Invoice here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */


import java.util.Calendar;

public class Invoice extends Serializable {
    public int buyerId;
    public int renterId;
    public Calendar time;
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

    protected Invoice(int id, int buyerId, int renterId){
        super(id);
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
        this.buyerId = buyerId;
        this.renterId = renterId;
        this.time = Calendar.getInstance();
    }

    public Invoice(int id, Account buyer, Renter renter) {
        super(id);
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
        this.buyerId = buyer.id;
        this.renterId = renter.id;
        this.time = Calendar.getInstance();
    }

    public String print(){
        return  "Id : " + this.id + " " +
                "Buyer Id : " + this.buyerId + " " +
                "Renter Id : " + this.renterId + " " +
                "Time : " + this.time + "\n\n";

    }


}