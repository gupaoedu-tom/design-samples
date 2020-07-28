package com.gupaoedu.vip.pattern.adapter.general.classadapter;

/**
 * Created by Tom.
 */
public class Client {
    public static void main(String[] args) {
        ITarget adapter = new Adapter();
        int result = adapter.request();
        System.out.println(result);
    }
}
