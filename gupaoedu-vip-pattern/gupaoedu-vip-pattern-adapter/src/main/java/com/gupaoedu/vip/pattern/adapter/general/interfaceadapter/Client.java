package com.gupaoedu.vip.pattern.adapter.general.interfaceadapter;


/**
 * Created by Tom.
 */
public class Client {
    public static void main(String[] args) {
        ITarget adapter = new Adapter(new Adaptee()) {
            @Override
            public int request1() {
                return adaptee.specificRequest() / 10;
            }
        };
        int result = adapter.request1();
        System.out.println(result);
    }
}
