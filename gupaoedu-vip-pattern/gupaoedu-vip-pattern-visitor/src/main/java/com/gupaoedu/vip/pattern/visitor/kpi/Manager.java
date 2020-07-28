package com.gupaoedu.vip.pattern.visitor.kpi;

import java.util.Random;

/**
 * Created by Tom.
 */
public class Manager extends Employee {
    public Manager(String name) {
        super(name);
    }

    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }

    //考核的是每年新产品研发数量
    public int getProducts(){
        return new Random().nextInt(10);
    }
}
