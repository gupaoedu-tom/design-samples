package com.gupaoedu.vip.pattern.factory.abstractfactory.course.factorys;

import com.gupaoedu.vip.pattern.factory.abstractfactory.course.products.INote;
import com.gupaoedu.vip.pattern.factory.abstractfactory.course.products.IVideo;
import com.gupaoedu.vip.pattern.factory.abstractfactory.course.products.PythonNote;
import com.gupaoedu.vip.pattern.factory.abstractfactory.course.products.PythonVideo;

/**
 * Created by Tom.
 */
public class PythonCourseFactory extends CourseFactory {

    public INote createNote() {
        super.init();
        return new PythonNote();
    }


    public IVideo createVideo() {
        super.init();
        return new PythonVideo();
    }
}
