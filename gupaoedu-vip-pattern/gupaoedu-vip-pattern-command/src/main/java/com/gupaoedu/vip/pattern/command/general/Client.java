package com.gupaoedu.vip.pattern.command.general;

/**
 * Created by Tom.
 */
public class Client {
    public static void main(String[] args) {
        ICommand cmd = new ConcreteCommand();
        Invoker invoker = new Invoker(cmd);
        invoker.action();
    }

    //接收者
    static class Receiver {
        public void action() {
            System.out.println("执行具体操作");
        }
    }

    //抽象命令接口
    interface ICommand {
        void execute();
    }

    //具体命令
    static class ConcreteCommand implements ICommand {
        // 直接创建接收者，不暴露给客户端
        private Receiver receiver = new Receiver();

        public void execute() {
            this.receiver.action();
        }
    }

    //请求者
    static class Invoker {
        private ICommand cmd;

        public Invoker(ICommand cmd) {
            this.cmd = cmd;
        }

        public void action() {
            this.cmd.execute();
        }
    }
}
