package com.gupaoedu.vip.pattern.delegate.simple;

/**
 * Created by Tom.
 */
public class EmployeeA implements IEmployee {
    protected String goodAt = "编程";
    public void doing(String task) {
        System.out.println("我是员工A，我擅长" + goodAt + ",现在开始做" +task + "工作");
    }
}
