package com.gupaoedu.vip.pattern.factory.abstractfactory.course;

import com.gupaoedu.vip.pattern.factory.abstractfactory.course.factorys.JavaCourseFactory;

/**
 * Created by Tom.
 */
public class Test {

    public static void main(String[] args) {

        JavaCourseFactory factory = new JavaCourseFactory();

        factory.createNote().edit();
        factory.createVideo().record();

    }

}
