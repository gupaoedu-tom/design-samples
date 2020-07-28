package com.gupaoedu.vip.pattern.chain.general;

/**
 * Created by Tom.
 */
public class Client {
    public static void main(String[] args) {
        Handler handlerA = new ConcreteHandlerA();
        Handler handlerB = new ConcreteHandlerB();
        handlerA.setNextHanlder(handlerB);
        handlerA.handleRequest("requestB");
    }

    //抽象处理者
    static abstract class Handler {

        protected Handler nextHandler;

        public void setNextHanlder(Handler successor) {
            this.nextHandler = successor;
        }

        public abstract void handleRequest(String request);

    }

    //具体处理者A
    static class ConcreteHandlerA extends Handler {

        public void handleRequest(String request) {
            if ("requestA".equals(request)) {
                System.out.println(this.getClass().getSimpleName() + "deal with request: " + request);
                return;
            }
            if (this.nextHandler != null) {
                this.nextHandler.handleRequest(request);
            }
        }
    }

    //具体处理者B
    static class ConcreteHandlerB extends Handler {

        public void handleRequest(String request) {
            if ("requestB".equals(request)) {
                System.out.println(this.getClass().getSimpleName() + "deal with request: " + request);
                return;
            }
            if (this.nextHandler != null) {
                this.nextHandler.handleRequest(request);
            }
        }
    }
}
