package com.gupaoedu.vip.pattern.objectpool.pool;

/**
 * Created by Tom.
 */
public class Client {

    public static void main(String[] args) {
        ObjectPoolFactory poolFactory = ObjectPoolFactory.getInstance();
        Attributes paraObj = new Attributes(2, 1);
        ObjectPool pool = poolFactory.createPool(paraObj, StringBuffer.class);
        StringBuffer buffer = (StringBuffer) pool.getObject();
        buffer.append("Tom");
        System.out.println(buffer.toString());
    }

}
