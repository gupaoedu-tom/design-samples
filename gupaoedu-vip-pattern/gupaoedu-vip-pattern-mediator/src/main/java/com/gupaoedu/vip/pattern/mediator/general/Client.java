package com.gupaoedu.vip.pattern.mediator.general;

/**
 * Created by Tom.
 */
public class Client {
    public static void main(String[] args) {
        Mediator mediator = new ConcreteMediator();
        ConcreteColleagueA colleagueA = new ConcreteColleagueA(mediator);
        ConcreteColleagueB colleagueB = new ConcreteColleagueB(mediator);
        colleagueA.depMethodA();
        System.out.println("-------------------------");
        colleagueB.depMethodB();
    }



    // 抽象同事类
    static abstract class Colleague {
        protected Mediator mediator;

        public Colleague(Mediator mediator) {
            this.mediator = mediator;
        }
    }

    // 具体同事类A
    static class ConcreteColleagueA extends Colleague {
        public ConcreteColleagueA(Mediator mediator) {
            super(mediator);
            this.mediator.setColleageA(this);
        }

        // 自有方法：self-Method
        public void selfMethodA() {
            // 处理自己的逻辑
            System.out.println(this.getClass().getSimpleName() + "，self-Method");
        }

        // 依赖方法：dep-Method
        public void depMethodA() {
            // 处理自己的逻辑
            System.out.println(this.getClass().getSimpleName() + ":depMethod: delegate to Mediator");
            // 无法处理的业务逻辑委托给中介者处理
            this.mediator.transferA();
        }
    }

    // 具体同事类B
    static class ConcreteColleagueB extends Colleague {
        public ConcreteColleagueB(Mediator mediator) {
            super(mediator);
            this.mediator.setColleageB(this);
        }

        // 自有方法：self-Method
        public void selfMethodB() {
            // 处理自己的逻辑
            System.out.println(this.getClass().getSimpleName() + "，self-Method");
        }

        // 依赖方法：dep-Method
        public void depMethodB() {
            // 处理自己的逻辑
            System.out.println(this.getClass().getSimpleName() + ":depMethod: delegate to Mediator");
            // 无法处理的业务逻辑委托给中介者处理
            this.mediator.transferB();
        }
    }

    // 抽象中介者
    static abstract class Mediator {
        protected ConcreteColleagueA colleagueA;
        protected ConcreteColleagueB colleagueB;

        public void setColleageA(ConcreteColleagueA colleague) {
            this.colleagueA = colleague;
        }

        public void setColleageB(ConcreteColleagueB colleague) {
            this.colleagueB = colleague;
        }

        // 中介者业务逻辑
        public abstract void transferA();

        public abstract void transferB();
    }

    // 具体中介者
    static class ConcreteMediator extends Mediator {
        @Override
        public void transferA() {
            // 协调行为:A 转发到 B
            this.colleagueB.selfMethodB();
        }

        @Override
        public void transferB() {
            // 协调行为:B 转发到 A
            this.colleagueA.selfMethodA();
        }
    }
}
