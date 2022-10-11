package BismaAlifAlghifariJSleepMN;


import java.util.Calendar;
import java.util.Date;

public class Invoice extends Serializable {
    public int buyerId;
    public int renterId;
    public Date time;
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
        this.time = new Date();
    }

    public Invoice(Account buyer, Renter renter) {
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
        this.buyerId = buyer.id;
        this.renterId = renter.id;
        this.time = new Date();
    }

    public String print(){
        return  "Id : " + this.id + " " +
                "Buyer Id : " + this.buyerId + " " +
                "Renter Id : " + this.renterId + " " +
                "Time : " + this.time + "\n\n";

    }


}
