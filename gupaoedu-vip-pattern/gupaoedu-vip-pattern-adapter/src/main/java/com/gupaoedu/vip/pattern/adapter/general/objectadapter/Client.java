package com.gupaoedu.vip.pattern.adapter.general.objectadapter;

/**
 * Created by Tom.
 */
public class Client {
    public static void main(String[] args) {
        ITarget adapter = new Adapter(new Adaptee());
        int result = adapter.request();
        System.out.println(result);
    }
}
