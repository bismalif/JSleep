package BismaAlifAlghifariJSleepMN;


/**
 * Write a description of class Payment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Calendar;
import java.text.SimpleDateFormat;
public class Payment extends Invoice {

    public Calendar to;
    public Calendar from;
    private int roomId;

    public Payment(int id, int buyerId, int renterId, int roomId) {
        super(id, buyerId, renterId);
        this.to = Calendar.getInstance();
        this.from = Calendar.getInstance();
        this.to.add(Calendar.DATE, 2);
        this.roomId = roomId;

    }

    public Payment(int id, Account buyer, Renter renter, int roomId) {
        super(id, buyer, renter);
        this.from = Calendar.getInstance();
        this.to = Calendar.getInstance();
        this.to.add(Calendar.DATE, 2);
        this.roomId = roomId;
    }

    public String getDuration(){
        SimpleDateFormat SDFormat = new SimpleDateFormat("dd MMMM yyyy");
        return SDFormat.format(this.from.getTime()) + " - " + SDFormat.format(this.to.getTime());
    }

    public String getTime(){
        SimpleDateFormat SDFormat = new SimpleDateFormat("'Formatted Date =' dd MMMM yyy");
        return SDFormat.format(this.from.getTime());
    }



    public String print() {
        return  "Id : " + id + " " +
                "Buyer Id : " + buyerId + " " +
                "Renter Id : " + renterId + " " +
                "Time : " + time + " " +
                "Room Id : " + roomId + " " +
                "From : " + from + " " +
                "To : " + to + "\n\n";
    }

    public int getRoomId(){
        return this.roomId;
    }

}