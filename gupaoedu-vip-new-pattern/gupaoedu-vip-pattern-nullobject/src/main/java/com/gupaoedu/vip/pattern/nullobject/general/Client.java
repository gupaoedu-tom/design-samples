package com.gupaoedu.vip.pattern.nullobject.general;

/**
 * Created by Tom.
 */
public class Client {

    public static void main(String[] args) {
        ObjectFactory factory = new ObjectFactory();
        System.out.println(factory.getObject("Joe").isNill());
        System.out.println(factory.getObject("Tom").isNill());
    }


    //抽象对象
    static abstract class AbstractObject{
        abstract void request();
        abstract boolean isNill();
    }

    //空对象
    static class NullObject extends AbstractObject{

        public void request() {
            System.out.println("Not Available Request");
        }

        boolean isNill() {
            return true;
        }
    }

    //真实对象
    static class RealObject extends AbstractObject{
        private String name;
        public RealObject(String name) {
            this.name = name;
        }

        public void request() {
            System.out.println("Do samething...");
        }

        boolean isNill() {
            return false;
        }
    }

    //对象工厂
    static class ObjectFactory{
        private static final String[] names = {"Tom","Mic","James"};

        public AbstractObject getObject(String name){
            for (String n : names) {
                if(n.equalsIgnoreCase(name)){
                    return new RealObject(name);
                }
            }
            return new NullObject();
        }
    }
}
