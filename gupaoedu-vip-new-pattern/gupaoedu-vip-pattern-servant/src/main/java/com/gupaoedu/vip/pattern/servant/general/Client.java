package com.gupaoedu.vip.pattern.servant.general;


/**
 * Created by Tom.
 */
public class Client {

    public static void main(String[] args) {
        Servant servant = new Servant();
        servant.service(new ConcreteServiced1());
        servant.service(new ConcreteServiced2());
    }
    /**
     * 通用功能
     */
    interface IServiced {
        //具有的特质或功能
        public void serviced();
    }

    /**
     * 具体功能
     */
    static class ConcreteServiced1 implements IServiced {
        public void serviced(){
            System.out.println("Serviced 1 doing");
        }
    }

    static class ConcreteServiced2 implements IServiced{
        public void serviced(){
            System.out.println("Serviced 2 doing");
        }
    }

    /**
     * 雇工类
     */
    static class Servant {
        //服务内容
        public void service(IServiced serviceFuture){
            serviceFuture.serviced();
        }
    }

}