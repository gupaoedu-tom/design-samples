package com.gupaoedu.vip.pattern.objectpool.pool;

public class PoolableObjectFactory {
    private static PoolableObjectFactory factory;
    private PoolableObjectFactory() {
    }

    public static synchronized PoolableObjectFactory getInstance() {
        if (factory == null) {
            factory = new PoolableObjectFactory();
        }
        return factory;
    }

    public Object createObject(Class classType) {
        Object obj = null;
        try {
            obj = classType.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
