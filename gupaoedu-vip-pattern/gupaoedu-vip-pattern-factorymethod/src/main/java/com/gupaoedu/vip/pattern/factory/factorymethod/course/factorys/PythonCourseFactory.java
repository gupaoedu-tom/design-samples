package com.gupaoedu.vip.pattern.factory.factorymethod.course.factorys;


import com.gupaoedu.vip.pattern.factory.factorymethod.course.products.ICourse;
import com.gupaoedu.vip.pattern.factory.factorymethod.course.products.PythonCourse;

/**
 * Created by Tom.
 */
public class PythonCourseFactory implements ICourseFactory {

    public ICourse create() {
        return new PythonCourse();
    }
}
