package com.gupaoedu.vip.pattern.observer.general;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tom.
 */
public class Client {

    public static void main(String[] args) {
        // 被观察者
        ISubject<String> observable = new ConcreteSubject<String>();
        // 观察者
        IObserver<String> observer = new ConcreteObserver<String>();
        // 注册
        observable.attach(observer);
        // 通知
        observable.notify("hello");
    }

    //抽象观察者
    public interface IObserver<E> {
        void update(E event);
    }

    //抽象主题者
    public interface ISubject<E> {
        boolean attach(IObserver<E> observer);

        boolean detach(IObserver<E> observer);

        void notify(E event);
    }

    //具体观察者
    static class ConcreteObserver<E> implements IObserver<E> {
        public void update(E event) {
            System.out.println("receive event: " + event);
        }
    }

    //具体主题者
    static class ConcreteSubject<E> implements ISubject<E> {
        private List<IObserver<E>> observers = new ArrayList<IObserver<E>>();

        public boolean attach(IObserver<E> observer) {
            return !this.observers.contains(observer) && this.observers.add(observer);
        }

        public boolean detach(IObserver<E> observer) {
            return this.observers.remove(observer);
        }

        public void notify(E event) {
            for (IObserver<E> observer : this.observers) {
                observer.update(event);
            }
        }
    }
}
