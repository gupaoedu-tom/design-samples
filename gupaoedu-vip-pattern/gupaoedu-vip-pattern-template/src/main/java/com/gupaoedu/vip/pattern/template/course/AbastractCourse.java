package com.gupaoedu.vip.pattern.template.course;

/**
 * Created by Tom.
 */
public abstract class AbastractCourse {
    
    public final void createCourse(){
        //1、发布预习资料
        postPreResoucse();
        
        //2、制作课件
        createPPT();
        
        //3、直播授课
        liveVideo();
        
        //4、上传课后资料
        postResource();
        
        //5、布置作业
        postHomework();
        
        if(needCheckHomework()){
            checkHomework();
        }
    }

    protected abstract void checkHomework();

    //钩子方法
    protected boolean needCheckHomework(){return  false;}

    protected void postHomework(){
        System.out.println("布置作业");
    }

    protected void postResource(){
        System.out.println("上传课后资料");
    }

    protected void liveVideo(){
        System.out.println("直播授课");
    }

    protected void createPPT(){
        System.out.println("制作课件");
    }

    protected void postPreResoucse(){
        System.out.println("发布预习资料");
    }

}
