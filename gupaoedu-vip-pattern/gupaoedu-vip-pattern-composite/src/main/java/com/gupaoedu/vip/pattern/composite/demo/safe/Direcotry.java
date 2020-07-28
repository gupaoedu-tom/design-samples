package com.gupaoedu.vip.pattern.composite.demo.safe;

/**
 * Created by Tom.
 */
public abstract class Direcotry {
    protected String name;

    public Direcotry(String name) {
        this.name = name;
    }

    public abstract void show();

//    public abstract void getType();
//
//    public abstract void isShare();
//
//    public abstract void delete();
//
//    public abstract void reName();

}
