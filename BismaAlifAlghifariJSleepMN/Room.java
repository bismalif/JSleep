package BismaAlifAlghifariJSleepMN;


public class Room extends Serializable {
    public int size;
    public String name;
    public Facility facility;
    public Price price;
    public String address;
    public BedType bedType;
    public City city;


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

}





