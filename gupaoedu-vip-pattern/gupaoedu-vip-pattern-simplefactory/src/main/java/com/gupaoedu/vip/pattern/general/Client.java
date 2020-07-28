package com.gupaoedu.vip.pattern.general;

/**
 * Created by Tom.
 */
public class Client {

    public static void main(String[] args) {

        new SimpleFactory().makeProduct(1);
    }

    //抽象产品
    public interface IProduct {
        void doSomething();
    }
    //具体产品：ProductA
    static class ConcreteProductA implements IProduct{
        public void doSomething() {
            System.out.println("I am Product A");
        }
    }
    //具体产品：ProductB
    static class ConcreteProductB implements IProduct{
        public void doSomething() {
            System.out.println("I am Product B");
        }
    }
    //具体产品：ProductC
    static class ConcreteProductC implements IProduct{
        public void doSomething() {
            System.out.println("I am Product C");
        }
    }

    final class Const {
        static final int PRODUCT_A = 0;
        static final int PRODUCT_B = 1;
        static final int PRODUCT_C = 2;
    }

    //SimpleFactory.java
    static class SimpleFactory {
        public static IProduct makeProduct(int kind) {
            switch (kind) {
                case Const.PRODUCT_A:
                    return new ConcreteProductA();
                case Const.PRODUCT_B:
                    return new ConcreteProductB();
                case Const.PRODUCT_C:
                    return new ConcreteProductC();
            }
            return null;
        }
    }
}
