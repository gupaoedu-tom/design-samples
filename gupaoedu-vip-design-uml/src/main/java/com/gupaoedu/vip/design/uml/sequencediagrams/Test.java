package com.gupaoedu.vip.design.uml.sequencediagrams;

/**
 * Created by Tom.
 */
public class Test {
    public static void main(String[] args) {
        Client client = new Client();
        client.work();
    }

    static class Device {
        void write(String str){
            //...
        }
    }

    static class Server {
        private Device device;
        public void open(){
            //...
        }
        public void print(String str){
            device.write(str);
            //...
        }
        public void close(){
            //...
        }
    }

    static class Client {
        private Server server;
        public void work(){
            server.open();
            server.print("hello");
            server.close();
        }
    }
}
