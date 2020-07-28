package com.gupaoedu.vip.pattern.singleton.general;

/**
 * Created by Tom.
 */
public class Client {
    public static void main(String[] args) {
        Singleton.getInstance();
    }

    static class Singleton {
        private static final Singleton instance = new Singleton();

        private Singleton(){}

        public static Singleton getInstance(){
            return  instance;
        }

    }
}
