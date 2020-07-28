package com.gupaoedu.vip.pattern.template.general;

/**
 * Created by Tom.
 */
public class Client {

    public static void main(String[] args) {
        AbstractClass abc = new ConcreteClassA();
        abc.templateMehthod();
        abc = new ConcreteClassB();
        abc.templateMehthod();
    }

    // 抽象模板类
    static abstract class AbstractClass {
        protected void step1() {
            System.out.println("AbstractClass:step1");
        }

        protected void step2() {
            System.out.println("AbstractClass:step2");
        }

        protected void step3() {
            System.out.println("AbstractClass:step3");
        }

        // 声明为final方法，避免子类覆写
        public final void templateMehthod() {
            this.step1();
            this.step2();
            this.step3();
        }
    }

    // 具体实现类A
    static class ConcreteClassA extends AbstractClass {

        protected void step1() {
            System.out.println("ConcreateClassA:step1");
        }
    }

    // 具体实现类B
    static class ConcreteClassB extends AbstractClass {

        protected void step2() {
            System.out.println("ConcreateClassB:step2");
        }
    }

}
