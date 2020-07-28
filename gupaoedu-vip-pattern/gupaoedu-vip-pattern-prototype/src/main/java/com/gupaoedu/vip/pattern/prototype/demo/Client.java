package com.gupaoedu.vip.pattern.prototype.demo;

/**
 * Created by Tom.
 */
public class Client {
    public static void main(String[] args) {

//        ExamPaper examPaper = new ExamPaper();
//        System.out.println(examPaper);

        ExamPaper examPaper = (ExamPaper)BeanUtils.copy(new ExamPaper());
        System.out.println(examPaper);
    }
}
