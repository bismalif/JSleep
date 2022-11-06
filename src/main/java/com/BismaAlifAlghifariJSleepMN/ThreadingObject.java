package com.BismaAlifAlghifariJSleepMN;

public class ThreadingObject extends Thread{
    public ThreadingObject(String name){
        super(name);
        this.start();
    }

    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName() + " is running");
        System.out.println("Id Thread " + Thread.currentThread().getId());
    }
}