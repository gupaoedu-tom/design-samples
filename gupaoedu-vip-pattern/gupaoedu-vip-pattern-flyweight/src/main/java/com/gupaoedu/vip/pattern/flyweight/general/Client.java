package com.gupaoedu.vip.pattern.flyweight.general;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tom.
 */
public class Client {
    public static void main(String[] args) {
        FlyweightFactory flyweightFactory = new FlyweightFactory();
        IFlyweight flyweight1 = flyweightFactory.getFlyweight("aa");
        IFlyweight flyweight2 = flyweightFactory.getFlyweight("bb");
        flyweight1.operation("a");
        flyweight2.operation("b");
    }

    interface IFlyweight {
        void operation(String extrinsicState);
    }

    // 具体享元角色
    static class ConcreteFlyweight implements IFlyweight {
        private String intrinsicState;

        public ConcreteFlyweight(String intrinsicState) {
            this.intrinsicState = intrinsicState;
        }


        public void operation(String extrinsicState) {
            System.out.println("Object address: " + System.identityHashCode(this));
            System.out.println("IntrinsicState: " + this.intrinsicState);
            System.out.println("ExtrinsicState: " + extrinsicState);
        }
    }

    // 享元工厂
    static class FlyweightFactory {

        private static Map<String, IFlyweight> pool = new HashMap<String, IFlyweight>();

        // 因为内部状态具备不变性，因此作为缓存的键
        public static IFlyweight getFlyweight(String intrinsicState) {
            if (!pool.containsKey(intrinsicState)) {
                IFlyweight flyweight = new ConcreteFlyweight(intrinsicState);
                pool.put(intrinsicState, flyweight);
            }
            return pool.get(intrinsicState);
        }
    }
}
