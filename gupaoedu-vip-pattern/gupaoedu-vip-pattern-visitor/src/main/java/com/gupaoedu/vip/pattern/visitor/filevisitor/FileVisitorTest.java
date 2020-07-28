package com.gupaoedu.vip.pattern.visitor.filevisitor;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;

/**
 * Created by Tom.
 */
public class FileVisitorTest {
    public static void main(String[] args) {
        try {
            // 使用FileVisitor对目录进行遍历
            Files.walkFileTree(Paths.get("E:", "WORKSPACE/gupaoedu-vip-pattern/gupaoedu-vip-pattern-visitor"), new SimpleFileVisitor<Path>() {

                // 在访问子目录前触发该方法

                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    System.out.println("正在访问" + dir + "目录");
                    return FileVisitResult.CONTINUE;
                }

                // 在访问文件时触发该方法
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    System.out.println("正在访问" + file + "文件");
                    if (file.endsWith("FileVisitorTest.java")) {
                        System.out.println("------FileVisitorTest.java,文件内容-----");
                        List<String> list = Files.readAllLines(file);
                        // 打印出文件的内容
                        System.out.println(list);
                        return FileVisitResult.TERMINATE;
                    }
                    return FileVisitResult.CONTINUE;
                }

                // 在访问失败时触发该方法
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    // 写一些具体的业务逻辑
                    return super.visitFileFailed(file, exc);
                }

                // 在访问目录之后触发该方法
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    // 写一些具体的业务逻辑
                    return super.postVisitDirectory(dir, exc);
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
