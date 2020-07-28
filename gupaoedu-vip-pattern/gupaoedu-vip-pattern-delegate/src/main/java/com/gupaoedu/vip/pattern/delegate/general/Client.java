package com.gupaoedu.vip.pattern.delegate.general;

import java.util.Random;

public class Client {
    public static void main(String[] args) {
        new Delegate().doTask();
    }

    //抽象任务角色
    interface ITask {
        void doTask();
    }

    //具体任务角色A
    static class ConcreteA implements ITask {
        public void doTask() {
            System.out.println("执行 , 由A实现");
        }
    }

    //具体任务角色B
    static class ConcreteB implements ITask {
        public void doTask() {
            System.out.println("执行 , 由B实现");
        }
    }

    //委派者角色
    static class Delegate implements ITask {
        public void doTask() {
            System.out.println("代理执行开始....");

            ITask task = null;
            if (new Random().nextBoolean()){
                task = new ConcreteA();
                task.doTask();
            }else{
                task = new ConcreteB();
                task.doTask();
            }

            System.out.println("代理执行完毕....");
        }
    }
}