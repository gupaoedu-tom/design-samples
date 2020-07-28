package com.gupaoedu.vip.pattern.composite.demo.transparent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tom.
 */
public class CoursePackage extends CourseComponet {
    private List<CourseComponet> itmes = new ArrayList<CourseComponet>();

    private String name;
    private Integer level;

    public CoursePackage(String name, Integer level) {
        this.name = name;
        this.level = level;
    }


    @Override
    public void addChild(CourseComponet componet) {
        itmes.add(componet);
    }

    @Override
    public void removeChild(CourseComponet componet) {
        itmes.remove(componet);
    }

    @Override
    public String getName(CourseComponet componet) {
        return this.name;
    }

    @Override
    public void print() {
        System.out.println(this.name);

        for (CourseComponet c : itmes) {
            if(this.level != null){
                for (int i = 0; i < this.level; i++) {
                    System.out.print("   ");
                }
                for (int i = 0; i < this.level; i++) {
                    if(i==0){
                        System.out.print("+");
                    }
                    System.out.print("-");
                }
            }

            c.print();
        }

    }
}
