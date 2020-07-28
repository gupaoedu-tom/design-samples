package com.gupaoedu.vip.pattern.memento.general;

/**
 * Created by Tom.
 */
public class Client {

    public static void main(String[] args) {
        //来一个发起人
        Originator originator = new Originator();
        //来一个备忘录管理员
        Caretaker caretaker = new Caretaker();
        //管理员存储发起人的备忘录
        caretaker.storeMemento(originator.createMemento());
        //发起人从管理员获取备忘录进行回滚
        originator.restoreMemento(caretaker.getMemento());
    }

    //发起人角色
    static class Originator {
        // 内部状态
        private String state;

        public String getState() {
            return this.state;
        }

        public void setState(String state) {
            this.state = state;
        }

        // 创建一个备忘录
        public Memento createMemento() {
            return new Memento(this.state);
        }

        // 从备忘录恢复
        public void restoreMemento(Memento memento) {
            this.setState(memento.getState());
        }
    }

    //备忘录角色
    static class Memento {
        private String state;

        public Memento(String state){
            this.state = state;
        }

        public String getState() {
            return this.state;
        }

        public void setState(String state) {
            this.state = state;
        }
    }

    //备忘录管理者角色
    static class Caretaker {
        // 备忘录对象
        private Memento memento;

        public Memento getMemento() {
            return this.memento;
        }

        public void storeMemento(Memento memento) {
            this.memento = memento;
        }
    }
}
