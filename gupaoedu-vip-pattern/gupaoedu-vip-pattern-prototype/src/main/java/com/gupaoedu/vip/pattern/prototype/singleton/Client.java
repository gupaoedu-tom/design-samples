package com.gupaoedu.vip.pattern.prototype.singleton;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tom.
 */
public class Client {


    public static void main(String[] args) {
        //创建原型对象
        ConcretePrototype prototype = ConcretePrototype.getInstance();

        //拷贝原型对象
        ConcretePrototype cloneType = prototype.clone();

        System.out.println("原型对象和克隆对象比较：" + (prototype == cloneType));

    }

}
