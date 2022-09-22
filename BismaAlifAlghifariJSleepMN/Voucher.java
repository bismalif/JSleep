package BismaAlifAlghifariJSleepMN;


public class Voucher {

    public Type type;
    public double cut;
    public String name;
    public int code;
    public double minimum;
    private boolean used;

    public Voucher(String name, int code, Type type, double minimum){
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

}

