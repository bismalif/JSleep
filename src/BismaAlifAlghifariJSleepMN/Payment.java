package BismaAlifAlghifariJSleepMN;



import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Payment extends Invoice  {

    public Date to;
    public Date from;
    private int roomId;

    public Payment(int id, int buyerId, int renterId, int roomId, Date
            from, Date to) {
        super(id, buyerId, renterId);
        this.to = to;
        this.from = from;
        this.roomId = roomId;

    }

    public Payment(int id, Account buyer, Renter renter, int roomId, Date
            from, Date to) {
        super(id, buyer, renter);
        this.to = to;
        this.from = from;
        this.roomId = roomId;
    }

    public String getTime(){
        SimpleDateFormat SDFormat = new SimpleDateFormat("'Formatted Date =' dd MMMM yyy");
        return SDFormat.format(this.from.getTime());
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
                "Time : " + time + " " +
                "Room Id : " + roomId + " " +
                "From : " + from + " " +
                "To : " + to + "\n\n";
    }

    public int getRoomId(){
        return this.roomId;
    }


}