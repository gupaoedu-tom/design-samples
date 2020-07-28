package com.gupaoedu.vip.pattern.factory.factorymethod.course.factorys;


import com.gupaoedu.vip.pattern.factory.factorymethod.course.products.ICourse;
import com.gupaoedu.vip.pattern.factory.factorymethod.course.products.JavaCourse;

/**
 * Created by Tom.
 */
public class JavaCourseFactory implements ICourseFactory {
    public ICourse create() {
        return new JavaCourse();
    }
}
