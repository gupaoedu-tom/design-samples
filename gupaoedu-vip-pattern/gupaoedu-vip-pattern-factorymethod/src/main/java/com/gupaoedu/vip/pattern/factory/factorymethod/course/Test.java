package com.gupaoedu.vip.pattern.factory.factorymethod.course;


import com.gupaoedu.vip.pattern.factory.factorymethod.course.factorys.ICourseFactory;
import com.gupaoedu.vip.pattern.factory.factorymethod.course.factorys.JavaCourseFactory;
import com.gupaoedu.vip.pattern.factory.factorymethod.course.factorys.PythonCourseFactory;
import com.gupaoedu.vip.pattern.factory.factorymethod.course.products.ICourse;

/**
 * Created by Tom.
 */
public class Test {

    public static void main(String[] args) {

        ICourseFactory factory = new PythonCourseFactory();
        ICourse course = factory.create();
        course.record();

        factory = new JavaCourseFactory();
        course = factory.create();
        course.record();

    }

}
