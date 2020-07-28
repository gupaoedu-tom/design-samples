package com.gupaoedu.vip.pattern.factory.abstractfactory.general;


/**
 * Created by Tom.
 */
public class Client {
    public static void main(String[] args) {
        IAbstractFactory factory = new ConcreteFactoryA();
        factory.makeProductA();
        factory.makeProductB();

        factory = new ConcreteFactoryB();
        factory.makeProductA();
        factory.makeProductB();


    }

    //抽象工厂类
    public interface IAbstractFactory {
        IAbstractProductA makeProductA();

        IAbstractProductB makeProductB();
    }

    //产品A抽象
    public interface IAbstractProductA {
        void doA();
    }

    //产品B抽象
    public interface IAbstractProductB {
        void doB();
    }

    //产品族A的具体产品A
    static class ConcreteProductAWithFamilyA implements IAbstractProductA{
        public void doA() {
            System.out.println("The ProductA be part of FamilyA");
        }
    }

    //产品族A的具体产品B
    static class ConcreteProductBWithFamilyA implements IAbstractProductB{
        public void doB() {
            System.out.println("The ProductB be part of FamilyA");
        }
    }

    //产品族B的具体产品A
    static class ConcreteProductAWithFamilyB implements IAbstractProductA{
        public void doA() {
            System.out.println("The ProductA be part of FamilyB");
        }
    }

    //产品族B的具体产品B
    static class ConcreteProductBWithFamilyB implements IAbstractProductB{
        public void doB() {
            System.out.println("The ProductB be part of FamilyB");
        }
    }

    //具体工厂类A
    static class ConcreteFactoryA implements IAbstractFactory{
        public IAbstractProductA makeProductA() {
            return new ConcreteProductAWithFamilyA();
        }

        public IAbstractProductB makeProductB() {
            return new ConcreteProductBWithFamilyA();
        }
    }

    //具体工厂类B
    static class ConcreteFactoryB implements IAbstractFactory{
        public IAbstractProductA makeProductA() {
            return new ConcreteProductAWithFamilyB();
        }

        public IAbstractProductB makeProductB() {
            return new ConcreteProductBWithFamilyB();
        }
    }
}
