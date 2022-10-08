package BismaAlifAlghifariJSleepMN;


public class Voucher extends Serializable implements FileParser{

    public Type type;
    public double cut;
    public String name;
    public int code;
    public double minimum;
    private boolean used;

    public Voucher(int id, String name, int code, Type type, boolean used, double
            minimum, double cut)
    {
        super(id);
        this.name = name;
        this.type = type;
        this.cut = cut;
        this.code = code;
        this.minimum = minimum;
        this.used = false;
    }

    public boolean canApply(Price price){
        return(price.price > minimum && used == false);
    }

    public double apply(Price price){
        used = true;
        if (this.type == Type.DISCOUNT){
            if (cut > 100){
                cut = 100;
            } return price.price - (price.price * (cut/100));
        }else{
            if (cut > 100){
                cut = price.price;
            } return price.price - cut;
        }
    }

    public boolean isUsed(){
        return used = true;
    }
    
    @Override
    public Object write() {
        return null;
    }

    public boolean read(String content) {
        return false;
    }    
}
