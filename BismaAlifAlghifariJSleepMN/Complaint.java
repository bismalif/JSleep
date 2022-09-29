package BismaAlifAlghifariJSleepMN;


/**
 * Write a description of class Complaint here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Complaint extends Serializable {
    public String desc;
    public String date;

    public Complaint(int id, String desc, String date) {
        super(id);
        this.desc = desc;
        this.date = date;
    }

    public String toString(){
        return "Id :" + id +
                "\nDesc : " + desc +
                "\nDate : " + date + "\n\n";
    }

}

