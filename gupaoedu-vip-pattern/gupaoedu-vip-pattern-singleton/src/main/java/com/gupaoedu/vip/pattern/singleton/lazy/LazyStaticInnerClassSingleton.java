package com.gupaoedu.vip.pattern.singleton.lazy;

/**
 * Created by Tom.
 */

/*
  ClassPath : LazyStaticInnerClassSingleton.class
              LazyStaticInnerClassSingleton$LazyHolder.class
   优点：写法优雅，利用了Java本身语法特点，性能高，避免了内存浪费,不能被反射破坏
   缺点：不优雅
 */
//这种形式兼顾饿汉式单例模式的内存浪费问题和synchronized的性能问题
//完美地屏蔽了这两个缺点
//自认为史上最牛的单例模式的实现方式
public class LazyStaticInnerClassSingleton {
    //使用LazyInnerClassGeneral的时候，默认会先初始化内部类
    //如果没使用，则内部类是不加载的
    private LazyStaticInnerClassSingleton(){
        if(LazyHolder.INSTANCE != null){
            throw new RuntimeException("不允许创建多个实例");
        }
    }
    //每一个关键字都不是多余的，static是为了使单例的空间共享，保证这个方法不会被重写、重载
    private static LazyStaticInnerClassSingleton getInstance(){
        //在返回结果以前，一定会先加载内部类
        return LazyHolder.INSTANCE;
    }

    //利用了Java本身语法特点，内部类默认不加载
    private static class LazyHolder{
        private static final LazyStaticInnerClassSingleton INSTANCE = new LazyStaticInnerClassSingleton();
    }

}
