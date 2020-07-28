package com.gupaoedu.vip.pattern.delegate.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tom.
 */
public class Leader implements IEmployee {

    private Map<String,IEmployee> employee = new HashMap<String,IEmployee>();

    public Leader(){
        employee.put("爬虫",new EmployeeA());
        employee.put("海报图",new EmployeeB());
    }

    public void doing(String task) {
        if(!employee.containsKey(task)){
            System.out.println("这个任务" +task + "超出我的能力范围");
            return;
        }
        employee.get(task).doing(task);
    }
}
