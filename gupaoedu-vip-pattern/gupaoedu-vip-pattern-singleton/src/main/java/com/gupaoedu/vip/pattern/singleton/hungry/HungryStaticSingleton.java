package com.gupaoedu.vip.pattern.singleton.hungry;

/**
 * Created by Tom.
 */
//饿汉式静态代码块单例模式
public class HungryStaticSingleton {
    private static final HungryStaticSingleton instance;

    static {
        instance = new HungryStaticSingleton();
    }

    private HungryStaticSingleton(){}

    public static HungryStaticSingleton getInstance(){
        return  instance;
    }
}
