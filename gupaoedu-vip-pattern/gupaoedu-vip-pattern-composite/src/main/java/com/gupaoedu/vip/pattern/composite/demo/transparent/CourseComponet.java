package com.gupaoedu.vip.pattern.composite.demo.transparent;

/**
 * Created by Tom.
 */
public abstract class CourseComponet {

    public void addChild(CourseComponet componet){
        throw new UnsupportedOperationException("不支持添加操作");
    }

    public void removeChild(CourseComponet componet){
        throw new UnsupportedOperationException("不支持删除操作");
    }

    public String getName(CourseComponet componet){
        throw new UnsupportedOperationException("不支持获取名称操作");
    }

    public double getPrice(CourseComponet componet){
        throw new UnsupportedOperationException("不支持获得价格操作");
    }

    public void print(){
        throw new UnsupportedOperationException("不支持打印操作");
    }

}
