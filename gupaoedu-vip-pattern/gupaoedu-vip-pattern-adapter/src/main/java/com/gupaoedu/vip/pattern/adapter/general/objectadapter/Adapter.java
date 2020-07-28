package com.gupaoedu.vip.pattern.adapter.general.objectadapter;

/**
 * Created by Tom.
 */
public class Adapter implements ITarget {
    private Adaptee adaptee;
    public Adapter(Adaptee adaptee){
        this.adaptee = adaptee;
    }
    public int request() {
        return adaptee.specificRequest() / 10;
    }
}
