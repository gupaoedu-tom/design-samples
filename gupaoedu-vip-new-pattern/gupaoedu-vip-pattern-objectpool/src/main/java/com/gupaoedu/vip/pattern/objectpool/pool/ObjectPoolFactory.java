package com.gupaoedu.vip.pattern.objectpool.pool;

public class ObjectPoolFactory {

    //  饿汉式单例类
    private static final ObjectPoolFactory factory = new ObjectPoolFactory();

    //  私有默认的构造子
    private ObjectPoolFactory() {
    }

    //  静态工厂方法
    public static ObjectPoolFactory getInstance() {
        return factory;
    }

    /**
     * @param paraObj  对象池参数对象
     * @param classType   所创建对象类型
     * @return   对象池
     */
    public ObjectPool createPool(Attributes paraObj, Class classType) {
        return new ObjectPool(paraObj, classType);
    }
}
