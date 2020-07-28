package com.gupaoedu.vip.design.principle.openclose;

/**
 * Created by Tom on 2020/2/16.
 */
public class JavaDiscountCourse extends JavaCourse {
    public JavaDiscountCourse(Integer id, String name, Double price) {
        super(id, name, price);
    }

    public Double getDiscountPrice(){
        return super.getPrice() * 0.6;
    }

}
