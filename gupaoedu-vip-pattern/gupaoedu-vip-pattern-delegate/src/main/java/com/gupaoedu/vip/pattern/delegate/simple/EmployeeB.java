package com.gupaoedu.vip.pattern.delegate.simple;

/**
 * Created by Tom.
 */
public class EmployeeB implements IEmployee {
    protected String goodAt = "平面设计";
    public void doing(String task) {
        System.out.println("我是员工B，我擅长" + goodAt + ",现在开始做" +task + "工作");
    }
}
