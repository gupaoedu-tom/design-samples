package com.gupaoedu.vip.pattern.prototype.singleton;


import lombok.Data;

import java.util.List;

/**
 * Created by Tom.
 */
@Data
public class ConcretePrototype implements Cloneable {

    private static  ConcretePrototype instance = new ConcretePrototype();

    private ConcretePrototype(){}

    public static ConcretePrototype getInstance(){
        return instance;
    }

    @Override
    public ConcretePrototype clone() {
        return instance;
    }

}
