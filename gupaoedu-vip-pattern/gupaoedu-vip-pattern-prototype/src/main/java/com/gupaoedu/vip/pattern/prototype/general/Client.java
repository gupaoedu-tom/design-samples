package com.gupaoedu.vip.pattern.prototype.general;

class Client {
    //客户类
    public static void main(String[] args) {
        //创建原型对象
        ConcretePrototypeA prototypeA = new ConcretePrototypeA("originalA");
        System.out.println(prototypeA);
        //拷贝原型对象
        ConcretePrototypeA cloneTypeA = prototypeA.clone();
        cloneTypeA.desc = "clone";
        System.out.println(cloneTypeA);

        //创建原型对象
        ConcretePrototypeB prototypeB = new ConcretePrototypeB("originalB");

        //拷贝原型对象
        ConcretePrototypeB cloneTypeB = prototypeB.clone();
        System.out.println(cloneTypeB);

    }

    //抽象原型
    interface IPrototype<T> {
        T clone();
    }

    //具体原型
    static class ConcretePrototypeB implements IPrototype<ConcretePrototypeB> {
        private String desc;

        public ConcretePrototypeB(String desc) {
            this.desc = desc;
        }

        @Override
        public ConcretePrototypeB clone() {
            //进行拷贝
            return new ConcretePrototypeB(this.desc);
        }

        @Override
        public String toString() {
            return "ConcretePrototypeB{" +
                    "desc='" + desc + '\'' +
                    '}';
        }
    }

    //具体原型
    static class ConcretePrototypeA implements IPrototype<ConcretePrototypeA> {
        private String desc;

        public ConcretePrototypeA(String desc) {
            this.desc = desc;
        }

        @Override
        public ConcretePrototypeA clone() {
            //进行拷贝
            return new ConcretePrototypeA(this.desc);
        }

        @Override
        public String toString() {
            return "ConcretePrototypeA{" +
                    "desc='" + desc + '\'' +
                    '}';
        }
    }
}