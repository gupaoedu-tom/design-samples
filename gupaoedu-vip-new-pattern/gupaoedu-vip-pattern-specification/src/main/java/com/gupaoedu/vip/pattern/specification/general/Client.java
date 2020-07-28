package com.gupaoedu.vip.pattern.specification.general;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tom.
 */
public class Client {

    public static void main(String[] args) {
        //待分析的对象
        List<Object> list = new ArrayList<Object>();
        //定义两个业务规格书
        ISpecification spec1 = new BizSpecification("a");
        ISpecification spec2 = new BizSpecification("a");

        list.add(spec1);
        list.add(spec2);
        //规格调用
        for (Object o : list) {
            if(spec1.and(spec2).isSatisfiedBy(o)){  //如果o满足spec1 && spec2
                System.out.println(o);
            }
        }
    }

    //抽象规格书
    interface ISpecification {
        //候选者是否满足条件
        boolean isSatisfiedBy (Object candidate) ;
        // and操作
        ISpecification and (ISpecification spec);
        // or操作
        ISpecification or (ISpecification spec);
        // not操作
        ISpecification not ();
    }

    //组合规格书
    static abstract class CompositeSpecification implements ISpecification {
        //是否满足条件由子类实现
        public abstract boolean isSatisfiedBy (Object candidate) ;
        // and操作
        public ISpecification and (ISpecification spec) {
            return new AndSpecification(this, spec);
        }
        // or操作
        public ISpecification or(ISpecification spec) {
            return new OrSpecification(this, spec);
        }
        // not操作
        public ISpecification not() {
            return new NotSpecification(this);
        }
    }

    //与规格书
    static class AndSpecification extends CompositeSpecification {
        //传递两个规格书进行and操作
        private ISpecification left;
        private ISpecification right;

        public AndSpecification(ISpecification left, ISpecification right) {
            this.left = left;
            this.right = right;
        }

        //进行and运算
        public boolean isSatisfiedBy(Object candidate) {
            return left.isSatisfiedBy(candidate) && right.isSatisfiedBy(candidate);
        }
    }


    static class OrSpecification extends CompositeSpecification {
        //传递两个规格书进行and操作
        private ISpecification left;
        private ISpecification right;

        public OrSpecification(ISpecification left, ISpecification right) {
            this.left= left;
            this.right = right;
        }

        //进行or运算
        public boolean isSatisfiedBy(Object candidate) {
            return left.isSatisfiedBy(candidate) || right.isSatisfiedBy(candidate);
        }
    }

    static class NotSpecification extends CompositeSpecification {
        //传递两个规格书进行and操作
        private ISpecification spec;

        public NotSpecification(ISpecification spec) {
            this.spec = spec;
        }

        //进行not运算
        public boolean isSatisfiedBy(Object candidate) {
            return !spec.isSatisfiedBy(candidate);
        }
    }

    //业务规格书
    static class BizSpecification extends CompositeSpecification {
        //基准对象，如姓名等，也可以是int等类型
        private String obj;
        public BizSpecification(String obj) {
            this.obj = obj;
        }
        //判断是否满足要求
        public boolean isSatisfiedBy(Object candidate){
            //根据基准对象判断是否符合
            return true;
        }
    }
}