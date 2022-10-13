package BismaAlifAlghifariJSleepMN;

import java.util.*;
import java.util.stream.Collectors;


public class Algorithm {

    private Algorithm() {
    }


    public static <T> List<T> collect (T[] array, T value){

        Predicate<T> predicate = value::equals;
        return collect(Arrays.stream(array).iterator(), predicate);

    }

    public static <T> List<T> collect (Iterable<T> iterable, T value){

        Predicate<T> predicate = value::equals;
        return collect(iterable.iterator(), predicate);

    }

    public static <T> List<T> collect (Iterator<T> iterator, T value){

        Predicate<T> predicate = value::equals;
        return collect(iterator, predicate);

    }

    public static <T> List<T> collect (T[] array, Predicate<T> pred){

        return collect(Arrays.stream(array).iterator(), pred);

    }

    public static <T> List<T> collect (Iterable<T> iterable, Predicate<T> pred){

        return collect(iterable.iterator(), pred);

    }

    public static <T> List<T> collect (Iterator<T> iterator, Predicate<T> pred){

        List<T> list = new ArrayList<T>();
        T obj;
        if (iterator.hasNext()) {
            do {
                obj = iterator.next();
                if (pred.predicate(obj)) {
                    list.add(obj);
                }
            } while (iterator.hasNext());
        }
        return list;

    }


    public static <T> int count(T[] array, T value) {

        final Iterator<T> var = Arrays.stream(array).iterator();
        return count(var, value);

    }

    public static <T> int count(Iterable<T> iterable, T value) {

        final Iterator <T> var = iterable.iterator();
        return count(var, value);

    }

    public static <T> int count(Iterator<T> iterator, T value) {

        final Predicate <T> var = value::equals;
        return count(iterator, var);

    }

    public static <T> int count(T[] array, Predicate<T> pred) {
        final Iterator<T> var = Arrays.stream(array).iterator();
        return count(var, pred);
    }

    public static <T> int count(Iterable<T> iterable, Predicate<T> pred) {

        final Iterator<T> var = iterable.iterator();
        return count(var, pred);

    }

    public static <T> int count(Iterator<T> iterator, Predicate<T> pred) {

        int counter = 0;
        while(iterator.hasNext()){
            if (pred.predicate(iterator.next())) {
                counter++;
            }
        }
        return counter;

    }


    public static <T> boolean exists(T[] array, T value) {

        Iterator<T> iterator = Arrays.stream(array).iterator();
        Predicate<T> pred = value::equals;
        return exists(iterator, value);

    }

    public static <T> boolean exists(Iterable<T> iterable, T value) {

        Predicate<T> pred = value::equals;
        return exists(iterable, pred);

    }

    public static <T> boolean exists(Iterator<T> iterator, T value) {

        Predicate<T> pred = value::equals;
        return exists(iterator, pred);

    }

    public static <T> boolean exists(T[] array, Predicate<T> pred) {

        Iterator<T> iterator = Arrays.stream(array).iterator();
        return exists(iterator, pred);

    }

    public static <T> boolean exists(Iterable<T> iterable, Predicate<T> pred) {

        return exists(iterable.iterator(), pred);

    }

    public static <T> boolean exists(Iterator<T> iterator, Predicate<T> pred) {

        while(iterator.hasNext()) {
            if(pred.predicate(iterator.next())) {
                return true;
            }
        }
        return false;

    }


    public static <T> T find (T[] array, T value){

        Predicate<T> predicate = value::equals;
        return find(Arrays.stream(array).iterator(), predicate);

    }

    public static <T> T find (Iterable<T> iterable, T value){

        Predicate<T> predicate = value::equals;
        return find(iterable.iterator(), predicate);

    }

    public static <T> T find (Iterator<T> iterator, T value){

        Predicate<T> predicate = value::equals;
        return find(iterator, predicate);

    }

    public static <T> T find (T[] array, Predicate<T> pred){

        return find(Arrays.stream(array).iterator(), pred);

    }

    public static <T> T find (Iterable<T> iterable, Predicate<T> pred){

        return find(iterable.iterator(), pred);

    }

    public static <T> T find (Iterator<T> iterator, Predicate<T> pred){

        T temp;
        while (iterator.hasNext()){
            temp = iterator.next();
            if (pred.predicate(temp)){
                return temp ;
            }
        }
        return null;

    }



    public static <T> List<T> paginate(T[] array, int page, int pageSize, Predicate<T> pred){

        Iterator<T> iterator = Arrays.stream(array).iterator();
        return paginate(iterator, page, pageSize, pred);

    }

    public static <T> List<T> paginate(Iterable<T> iterable, int page, int pageSize, Predicate<T> pred){

        final Iterator<T> iterator = iterable.iterator();
        return paginate(iterator, page, pageSize, pred);

    }

    public static <T> List<T> paginate(Iterator<T> iterator, int page, int pageSize, Predicate<T> pred) {

        List<T> list = new ArrayList<T>();
        int count = 0;
        while (iterator.hasNext()){
            if (pred.predicate(iterator.next())) {
                if (count >= page * pageSize && count < (page * pageSize) + pageSize) {
                    list.add(iterator.next());
                }
                count++;
            }
        }
        return list;

    }


}
