package com.gupaoedu.vip.pattern.objectpool.general;


import java.util.Iterator;
import java.util.Vector;

/**
 * Created by Tom.
 */
public class Client {

    public static void main(String[] args) {
        ObjectPool pool = new ObjectPool(10,50);
        IPooledObject object = pool.borrowObject();
        object.operation();
        pool.returnObject(object);
        System.out.println();
    }

    // 抽象对象
    interface IPooledObject {
        void operation();
    }
    // 具体对象
    static class ConcretePoolObject implements IPooledObject {
        public void operation() {
            System.out.println("doing");
        }
    }

    // 对象池
    static class ObjectPool {
        private int step = 10;   //当对象不够用的时候，每次扩容的数量
        private int minCount;
        private int maxCount;
        private Vector<IPooledObject> returneds;   //保存未借出的对象
        private Vector<IPooledObject> borroweds; //保存已被借出的对象

        //初始化对象池
        public ObjectPool(int minCount,int maxCount){
            borroweds = new Vector<IPooledObject>();
            returneds = new Vector<IPooledObject>();

            this.minCount = minCount;
            this.maxCount = maxCount;

            refresh(this.minCount);
        }

        // 因为内部状态具备不变性，因此作为缓存的键
        public IPooledObject borrowObject() {
            IPooledObject next = null;
            if(returneds.size() > 0){
                Iterator<IPooledObject> i = returneds.iterator();
                while (i.hasNext()){
                    next = i.next();
                    returneds.remove(next);
                    borroweds.add(next);
                    return next;
                }
            }else{
                //计算出剩余可创建的对象数
                int count = (maxCount - minCount);
                //剩余可创建的数量大于单次固定创建的对象数
                //则再初始化一批固定数量的对象
                refresh(count > step ? step : count);
            }
            return next;
        }

        //不需要使用的对象归还重复利用
        public void returnObject(IPooledObject pooledObject){
            returneds.add(pooledObject);
            if(borroweds.contains(pooledObject)){
                borroweds.remove(pooledObject);
            }
        }

        private void refresh(int count){
            for (int i = 0; i < count; i++) {
                returneds.add(new ConcretePoolObject());
            }
        }
    }
}