package com.gupaoedu.vip.pattern.visitor.general;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Client {
    public static void main(String[] args) {
        ObjectStructure collection = new ObjectStructure();
        System.out.println("ConcreteVisitorA handle elements:");
        IVisitor visitorA = new ConcreteVisitorA();
        collection.accept(visitorA);
        System.out.println("------------------------------------");
        System.out.println("ConcreteVisitorB handle elements:");
        IVisitor visitorB = new ConcreteVisitorB();
        collection.accept(visitorB);

    }

    // 抽象元素
    interface IElement {
        void accept(IVisitor visitor);
    }

    // 具体元素A
    static class ConcreteElementA implements IElement {

        public void accept(IVisitor visitor) {
            visitor.visit(this);
        }

        public String operationA() {
            return this.getClass().getSimpleName();
        }
    }

    // 具体元素B
    static class ConcreteElementB implements IElement {

        public void accept(IVisitor visitor) {
            visitor.visit(this);
        }

        public int operationB() {
            return new Random().nextInt(100);
        }
    }

    // 抽象访问者
    interface IVisitor {
        void visit(ConcreteElementA element);

        void visit(ConcreteElementB element);
    }

    // 具体访问者A
    static class ConcreteVisitorA implements IVisitor {

        public void visit(ConcreteElementA element) {
            String result = element.operationA();
            System.out.println("result from " + element.getClass().getSimpleName() + ": " + result);
        }


        public void visit(ConcreteElementB element) {
            int result = element.operationB();
            System.out.println("result from " + element.getClass().getSimpleName() + ": " + result);
        }
    }

    // 具体访问者B
    static class ConcreteVisitorB implements IVisitor {

        public void visit(ConcreteElementA element) {
            String result = element.operationA();
            System.out.println("result from " + element.getClass().getSimpleName() + ": " + result);
        }


        public void visit(ConcreteElementB element) {
            int result = element.operationB();
            System.out.println("result from " + element.getClass().getSimpleName() + ": " + result);
        }
    }

    // 结构对象
    static class ObjectStructure {
        private List<IElement> list = new ArrayList<IElement>();

        {
            this.list.add(new ConcreteElementA());
            this.list.add(new ConcreteElementB());
        }

        public void accept(IVisitor visitor) {
            for (IElement element : this.list) {
                element.accept(visitor);
            }
        }
    }
}