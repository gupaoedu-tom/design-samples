package com.gupaoedu.vip.pattern.factory.simplefactory;

import org.slf4j.LoggerFactory;

import java.util.Calendar;

/**
 * Created by Tom.
 */
public class Test {
    public static void main(String[] args) {
        ICouse couse = new CourseFactory().create(JavaCouse.class);
        couse.record();
    }
}
