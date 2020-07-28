package com.gupaoedu.vip.pattern.composite.demo.safe;

import java.lang.reflect.Field;

/**
 * Created by Tom.
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("==========安全模式的写法=============");

        Folder im = new Folder("即时聊天",2);


        File qq = new File("QQ.exe");
        File wx = new File("微信.exe");

        Folder sns = new Folder("社交",3);
        Folder love = new Folder("两性",4);
        Folder normal = new Folder("职场",4);
        Folder high = new Folder("高端",5);
        Folder low = new Folder("低端",5);


        File momo = new File("Momo.exe");
        love.add(momo);

        File maimai = new File("Maimai.exe");
        low.add(maimai);

        File boss = new File("Boss直聘.exe");
        high.add(boss);

        normal.add(high);
        normal.add(low);

        sns.add(love);
        sns.add(normal);

        im.add(qq);
        im.add(wx);
        im.add(sns);


        Folder office = new Folder("办公软件",2);

        File word = new File("Word.exe");
        File ppt = new File("PowerPoint.exe");
        File excel = new File("Excel.exe");


        office.add(word);
        office.add(ppt);
        office.add(excel);

        Folder root = new Folder("D盘",1);

        root.add(im);
        root.add(office);

        System.out.println("=============show()=============");
        root.show();

        System.out.println("=============list()=============");
        root.list();
    }
}
