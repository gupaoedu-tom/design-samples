package com.gupaoedu.vip.pattern.singleton.hungry;

/**
 * Created by Tom.
 */

/**
 * 优点：执行效率高，性能高，没有任何的锁
 * 缺点：某些情况下，可能会造成内存浪费
 */
//饿汉式静态代码块单例模式
public class HungrySingleton {

    private static final HungrySingleton instance = new HungrySingleton();

    private HungrySingleton(){}

    public static HungrySingleton getInstance(){
        return  instance;
    }
}
