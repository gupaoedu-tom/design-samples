package com.gupaoedu.vip.pattern.singleton.test;

import com.gupaoedu.vip.pattern.singleton.lazy.LazyStaticInnerClassSingleton;

import java.lang.reflect.Constructor;

/**
 * Created by Tom.
 */
public class ReflectTest {

    public static void main(String[] args) {
        try {
            Class<?> clazz = LazyStaticInnerClassSingleton.class;
            Constructor c = clazz.getDeclaredConstructor(null);


            c.setAccessible(true);

            Object instance1 = c.newInstance();

            Object instance2 = c.newInstance();


            System.out.println(instance1);

            System.out.println(instance2);

            System.out.println(instance1 == instance2);


//            Enum

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
