package BismaAlifAlghifariJSleepMN;


/**
 * Write a description of class Payment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Payment extends Invoice {

    public String to;
    public String from;
    private int roomId;

    public Payment(int id, int buyerId, int renterId, String time, int roomId,
                   String from, String to) {
        super(id, buyerId, renterId, time);
        this.to = to;
        this.from = from;
        this.roomId = roomId;
    }

    public Payment(int id, Account buyer, Renter renter, String time, int roomId,
                   String from, String to) {
        super(id, buyer, renter, time);
        this.to = to;
        this.from = from;
        this.roomId = roomId;
    }

    public String print() {
        return  "Id : " + id + " " +
                "Buyer Id : " + buyerId + " " +
                "Renter Id : " + renterId + " " +
                "Time : " + time + " " +
                "Room Id : " + roomId + " " +
                "From : " + from + " " +
                "To : " + to;
    }

    public int getRoomId(){
        return this.roomId;
    }

}
