package com.gupaoedu.vip.pattern.bridge.general;

/**
 * Created by Tom.
 */
public class Client {
    public static void main(String[] args) {
        // 来一个实现化角色
        IImplementor imp = new ConcreteImplementorA();
        // 来一个抽象化角色，聚合实现
        Abstraction abs = new RefinedAbstraction(imp);
        // 执行操作
        abs.operation();
    }

    // 抽象
    static abstract class Abstraction {

        protected IImplementor implementor;

        public Abstraction(IImplementor implementor) {
            this.implementor = implementor;
        }

        public void operation() {
            this.implementor.operationImpl();
        }
    }

    // 修正抽象
    static class RefinedAbstraction extends Abstraction {
        public RefinedAbstraction(IImplementor implementor) {
            super(implementor);
        }

        @Override
        public void operation() {
            super.operation();
            System.out.println("refined operation");
        }
    }

    // 抽象实现
    interface IImplementor {
        void operationImpl();
    }

    // 具体实现A
    static class ConcreteImplementorA implements IImplementor {

        public void operationImpl() {
            System.out.println("I'm ConcreteImplementor A");
        }
    }

    // 具体实现B
    static class ConcreteImplementorB implements IImplementor {

        public void operationImpl() {
            System.out.println("I'm ConcreteImplementor B");
        }
    }
}
