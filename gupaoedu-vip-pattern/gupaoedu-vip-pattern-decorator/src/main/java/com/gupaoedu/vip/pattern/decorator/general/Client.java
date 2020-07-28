package com.gupaoedu.vip.pattern.decorator.general;

public class Client{
    public static void main(String[] args){
        Component c1 = new ConcreteComponent (); //首先创建需要被装饰的原始对象(即要被装饰的对象)
        Decorator decoratorA = new ConcreteDecoratorA(c1); //给对象透明的增加功能A并调用
        decoratorA .operation();
        Decorator decoratorB = new ConcreteDecoratorB(c1); //给对象透明的增加功能B并调用
        decoratorB .operation();
        Decorator decoratorBandA = new ConcreteDecoratorB(decoratorA);//装饰器也可以装饰具体的装饰对象，此时相当于给对象在增加A的功能基础上在添加功能B
        decoratorBandA.operation();
    }

    //抽象组件
    static abstract class Component {
        /**
         * 示例方法
         */
        public abstract void operation();
    }

    //具体组件
    static class ConcreteComponent extends Component {
        public void operation() {
            //相应的功能处理
            System.out.println("处理业务逻辑");
        }
    }

    static abstract class Decorator extends Component {
        /**
         * 持有组件对象
         */
        protected Component component;

        /**
         * 构造方法，传入组件对象
         * @param component 组件对象
         */
        public Decorator(Component component) {
            this.component = component;
        }

        public void operation() {
            //转发请求给组件对象，可以在转发前后执行一些附加动作
            component.operation();
        }
    }

    //具体装饰器A
    static class ConcreteDecoratorA extends Decorator {
        public ConcreteDecoratorA(Component component) {
            super(component);
        }
        private void operationFirst(){ } //在调用父类的operation方法之前需要执行的操作
        private void operationLast(){ } //在调用父类的operation方法之后需要执行的操作
        public void operation() {
            //调用父类的方法，可以在调用前后执行一些附加动作
            operationFirst(); //添加的功能
            super.operation();  //这里可以选择性的调用父类的方法，如果不调用则相当于完全改写了方法，实现了新的功能
            operationLast(); //添加的功能
        }
    }

    //具体装饰器B
    static class ConcreteDecoratorB extends Decorator {
        public ConcreteDecoratorB(Component component) {
            super(component);
        }
        private void operationFirst(){ } //在调用父类的operation方法之前需要执行的操作
        private void operationLast(){ } //在调用父类的operation方法之后需要执行的操作
        public void operation() {
            //调用父类的方法，可以在调用前后执行一些附加动作
            operationFirst(); //添加的功能
            super.operation();  //这里可以选择性的调用父类的方法，如果不调用则相当于完全改写了方法，实现了新的功能
            operationLast(); //添加的功能
        }
    }
}  