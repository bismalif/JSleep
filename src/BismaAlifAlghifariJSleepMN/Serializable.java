package BismaAlifAlghifariJSleepMN;


import java.util.HashMap;

public class Serializable{
    private static HashMap <Class<?>, Integer > mapCounter = new HashMap<>();
    public final int id;
    protected Serializable (){
        Integer counter = mapCounter.get(getClass());
        if (counter == null){
            counter = 0;
        } else {
            counter++;
        }
    mapCounter.put(getClass(), counter);
    this.id = counter;
    }


    public int compareTo(Serializable other){
        return Integer.compare(this.id, other.id);
    }

    public boolean equals(Object other){
        return other instanceof Serializable && ((Serializable) other).id == id;
    }

    public boolean equals(Serializable other){
        return other.id == id;
    }

    public static <T extends Serializable> Integer getClosingId(Class<?> Class){
        return mapCounter.get(Class);
    }

    public static <T extends Serializable> Integer setClosingId(Class<?> Class, int id){
        return mapCounter.put(Class, id);
    }




}


