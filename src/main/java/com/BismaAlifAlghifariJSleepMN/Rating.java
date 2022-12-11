package com.BismaAlifAlghifariJSleepMN;

/**
 * This enum represents the different types of beds that a hotel room can have.
 *
 * @author Bisma Alif Alghifari
 * @version 1.0
 * @since   2022-12-11
 */
public class Rating
{
    /**
     *  The total rating from the users.
     */
    private long total;

    /**
     *  The number of how many users make ratings.
     */
    private long count;

    /**
     * This constructor is used to create a new Rating object.
     */
    public Rating() {
        this.total = 0;
        this.count = 0;
    }

    /**
     * This method is used to get the average rating of a hotel.
     * @return The average rating of a hotel.
     */
    public void insert(int rating){
        total += rating;
        count++;
    }

    /**
     * This method is used to get the average rating of a hotel.
     * @return The average rating of a hotel.
     */
    public double getAverage() {
        if(count == 0) {
            return 0;
        }return total / count;
    }

    /**
     * This method is used to get the average rating of a hotel.
     * @return The average rating of a hotel.
     */
    public long getCount(){
        return count;
    }

    /**
     * This method is used to get the average rating of a hotel.
     * @return The average rating of a hotel.
     */
    public long getTotal() {
        return total;
    }

    /**
     * This method is used to get the average rating of a hotel.
     * @return The average rating of a hotel.
     */
    public String toString(){
        return "Total :" + total +
                "\nCount : " + count + "\n\n";
    }
}

