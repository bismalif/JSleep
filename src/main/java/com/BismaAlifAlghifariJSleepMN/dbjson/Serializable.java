package com.BismaAlifAlghifariJSleepMN.dbjson;


import java.util.HashMap;
public class Serializable implements Comparable<Serializable>
{
    public final int id;
    private static HashMap<Class<?>,Integer> mapCounter = new HashMap<Class<?>,Integer>() ;

    protected Serializable(){

        Integer count = mapCounter.get(this.getClass());
        if(count == null){
            count = 0;
            mapCounter.put(getClass(),count);
        }
        else {
            count++;
            mapCounter.put(getClass(),count);
        }

        this.id = count;
    }

    public static <T extends Serializable> Integer getClosingId(Class<T> obj){
        return mapCounter.get(obj);
    }

    public static <T extends Serializable> Integer setClosingId(Class<T> obj, int data){
        return mapCounter.put(obj,data);
    }

    public int compareTo(Serializable param){
        return Integer.compare(this.id,param.id);
    }

    public boolean equals(Object obj)
    {
        return (obj instanceof Serializable) && ((Serializable) obj).id == id;
    }
    public boolean equals(Serializable obj)
    {
        return obj.id == this.id;
    }


}

