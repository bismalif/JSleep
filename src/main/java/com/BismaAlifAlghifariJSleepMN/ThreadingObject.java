package com.BismaAlifAlghifariJSleepMN;
/**
 * This enum represents the different types of beds that a hotel room can have.
 *
 * @author Bisma Alif Alghifari
 * @version 1.0
 * @since 11 December 2022
 */
public class ThreadingObject extends Thread{
    public ThreadingObject(String name){
        super(name);
        this.start();
    }

    /**
     * This method is used to get the price of a room.
     * @return The price of a room.
     */
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName() + " is running");
        System.out.println("Id Thread " + Thread.currentThread().getId());
    }
}