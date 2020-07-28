package com.gupaoedu.vip.pattern.factory.abstractfactory.course.factorys;

import com.gupaoedu.vip.pattern.factory.abstractfactory.course.products.INote;
import com.gupaoedu.vip.pattern.factory.abstractfactory.course.products.IVideo;
import com.gupaoedu.vip.pattern.factory.abstractfactory.course.products.JavaNote;
import com.gupaoedu.vip.pattern.factory.abstractfactory.course.products.JavaVideo;

/**
 * Created by Tom.
 */
public class JavaCourseFactory extends CourseFactory {

    public INote createNote() {
        super.init();
        return new JavaNote();
    }

    public IVideo createVideo() {
        super.init();
        return new JavaVideo();
    }
}
