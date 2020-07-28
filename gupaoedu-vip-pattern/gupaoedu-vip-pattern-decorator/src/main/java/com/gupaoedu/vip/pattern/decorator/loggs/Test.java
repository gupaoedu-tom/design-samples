package com.gupaoedu.vip.pattern.decorator.loggs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * Created by Tom.
 */
public class Test {

//    private static final Logger logger = LoggerFactory.getLogger(Test.class);
    private static final Logger logger = JsonLoggerFactory.getLogger(Test.class);

    public static void main(String[] args) {
        logger.error("系统错误");


        try {

            InputStream in = new FileInputStream("test.txt");

            // 字节缓存流
            BufferedInputStream bis = new BufferedInputStream(in);

            bis.read();
            bis.close();



            BufferedReader br = new BufferedReader(new FileReader(""));
            br.readLine();

            BufferedReader bs = new BufferedReader(new StringReader(""));
            bs.readLine();


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
