package com.gupaoedu.vip.pattern.builder.simple;

/**
 * Created by Tom.
 */
public class Test {

    public static void main(String[] args) {
        CourseBuilder builder = new CourseBuilder();

        builder.addName("设计模式");
        builder.addPpt("【PPT课件】");
        builder.addVideo("【录播视频】");

        System.out.println(builder.builder());
    }

}
