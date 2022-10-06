package BismaAlifAlghifariJSleepMN;


//package BismaAlifAlghifariJSleepMN;

import java.util.ArrayList;
import java.util.Date;

public class Room extends Serializable implements FileParser {
    public int size;
    public String name;
    public Facility facility;
    public Price price;
    public String address;
    public BedType bedType;
    public City city;
    public ArrayList<Date> booked;


    public Room(int id, String name, int size, Price price,
                Facility facility, City city, String address)
    {
        super(id);
        this.city = city;
        this.address = address;
        this.name = name;
        this.size = size;
        this.price = price;
        this.facility = facility;
        this.booked = new ArrayList<Date>();
    }

    public String toString(){
        return "Id : " + id +
                "\nCity : " + city +
                "\nAddress : " + address +
                "\nName : " + name +
                "\nSize : " + size +
                "\n" + price +
                "\nFacility : " + facility +
                "\nBed Type : " + bedType + "\n\n";
    }

    @Override
    public Object write() {
        return null;
    }

    public boolean read(String content) {
        return false;
    }
}

