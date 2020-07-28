package com.gupaoedu.vip.design.principle.liskovsutiution.methodreturn;

/**
 * Created by Tom on 2020/2/16.
 */
public class MethodReturnTest {
    public static void main(String[] args) {
        Base child = new Child();
        System.out.println(child.method());
    }
}
