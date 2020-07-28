package com.gupaoedu.vip.pattern.singleton.lazy;

/**
 * Created by Tom.
 */

/**
 * 优点：节省了内存,线程安全
 * 缺点：性能低
 */
//懒汉式单例模式在外部需要使用的时候才进行实例化
public class LazySimpleSingletion {
    //静态块，公共内存区域
    private static LazySimpleSingletion instance;

    private LazySimpleSingletion(){}

    public synchronized static LazySimpleSingletion getInstance(){
        if(instance == null){
            instance = new LazySimpleSingletion();
        }
        return instance;
    }
}
