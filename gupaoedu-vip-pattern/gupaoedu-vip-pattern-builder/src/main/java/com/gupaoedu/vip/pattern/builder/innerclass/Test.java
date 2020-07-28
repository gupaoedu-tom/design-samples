package com.gupaoedu.vip.pattern.builder.innerclass;

import com.gupaoedu.vip.pattern.builder.chain.CourseBuilder;

/**
 * Created by Tom.
 */
public class Test {
    public static void main(String[] args) {
         Course course = new Course.Builder()
                .addName("设计模式")
                .addPpt("【PPT课件】")
                .addVideo("【录播视频】")
                 .builder();

        System.out.println(course);
    }
}
