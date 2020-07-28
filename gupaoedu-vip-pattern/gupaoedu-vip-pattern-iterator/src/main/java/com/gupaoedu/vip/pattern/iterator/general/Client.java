package com.gupaoedu.vip.pattern.iterator.general;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tom.
 */
public class Client {
    public static void main(String[] args) {
        //来一个容器对象
        IAggregate<String> aggregate = new ConcreteAggregate<String>();
        //添加元素
        aggregate.add("one");
        aggregate.add("two");
        aggregate.add("three");
        //获取容器对象迭代器
        Iterator<String> iterator = aggregate.iterator();
        //遍历
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);
        }

    }

    //抽象迭代器
    interface Iterator<E> {

        E next();

        boolean hasNext();
    }

    //抽象容器
    interface IAggregate<E> {
        boolean add(E element);

        boolean remove(E element);

        Iterator<E> iterator();
    }

    //具体迭代器
    static class ConcreteIterator<E> implements Iterator<E> {
        private List<E> list;
        private int cursor = 0;

        public ConcreteIterator(List<E> list) {
            this.list = list;
        }


        public E next() {
            return this.list.get(this.cursor ++);
        }


        public boolean hasNext() {
            return this.cursor < this.list.size();
        }
    }

    //具体容器
    static class ConcreteAggregate<E> implements IAggregate<E> {
        private List<E> list = new ArrayList<E>();

        public boolean add(E element) {
            return this.list.add(element);
        }

        public boolean remove(E element) {
            return this.list.remove(element);
        }

        public Iterator<E> iterator() {
            return new ConcreteIterator<E>(this.list);
        }
    }
}
