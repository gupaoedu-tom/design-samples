package com.gupaoedu.vip.pattern.factory.factorymethod.general;

/**
 * Created by Tom.
 */
public class Client {
    public static void main(String[] args) {
        IFactory factory = new ConcreteFactoryA();
        factory.makeProduct().doSomething();

        factory = new ConcreteFactoryB();
        factory.makeProduct().doSomething();

        factory = new ConcreteFactoryC();
        factory.makeProduct().doSomething();
    }

    //抽象工厂
    public interface IFactory {
        IProduct makeProduct();
    }
    //生产ProductA的具体工厂类
    static class ConcreteFactoryA implements IFactory {
        public IProduct makeProduct() {
            return new ConcreteProductA();
        }
    }
    //生产ProductB的具体工厂类
    static class ConcreteFactoryB implements IFactory {
        public IProduct makeProduct() {
            return new ConcreteProductB();
        }
    }

    //生产ProductC的具体工厂类
    static class ConcreteFactoryC implements IFactory {
        public IProduct makeProduct() {
            return new ConcreteProductC();
        }
    }


    //抽象产品
    public interface IProduct {
        void doSomething();
    }

    //具体产品：ProductA
    static class ConcreteProductA implements IProduct {
        public void doSomething() {
            System.out.println("I am Product A");
        }
    }

    //具体产品：ProductB
    static class ConcreteProductB implements IProduct {
        public void doSomething() {
            System.out.println("I am Product B");
        }
    }

    //具体产品：ProductC
    static class ConcreteProductC implements IProduct {
        public void doSomething() {
            System.out.println("I am Product C");
        }
    }
}
