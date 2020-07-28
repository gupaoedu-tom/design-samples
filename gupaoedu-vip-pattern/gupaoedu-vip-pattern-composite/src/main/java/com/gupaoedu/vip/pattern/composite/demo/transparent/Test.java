package com.gupaoedu.vip.pattern.composite.demo.transparent;

/**
 * Created by Tom.
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("============透明的组合模式==============");

        CourseComponet javaBase = new Course("Java入门课程",8280);
        CourseComponet ai = new Course("人工智能",5000);

        CourseComponet packageCourse = new CoursePackage("Java架构师课程",2);

        CourseComponet design = new Course("Java设计模式",1500);
        CourseComponet source = new Course("源码分析",2000);
        CourseComponet softSkill = new Course("软技能",3000);

        packageCourse.addChild(design);
        packageCourse.addChild(source);
        packageCourse.addChild(softSkill);

        CourseComponet catalog = new CoursePackage("咕泡课程目录",1);
        catalog.addChild(javaBase);
        catalog.addChild(ai);
        catalog.addChild(packageCourse);

        catalog.print();

    }
}
