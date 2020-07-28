package com.gupaoedu.vip.design.principle.demeter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tom on 2020/2/16.
 */
public class Employee {

    public void checkNumberOfCourses(){
        List<Course> courseList = new ArrayList<Course>();
        for (int i = 0; i < 20; i ++){
            courseList.add(new Course());
        }
        System.out.println("目前已发布的课程数量为：" + courseList.size());
    }
}
