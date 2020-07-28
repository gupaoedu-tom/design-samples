package com.gupaoedu.vip.design.principle.simpleresponsibility.interfaced;

/**
 * Created by Tom on 2020/2/16.
 */
public interface ICourse {

    String getCourseName();
    byte[] getCourseVideo();

    void studyCourse();
    void refundCourse();
}
