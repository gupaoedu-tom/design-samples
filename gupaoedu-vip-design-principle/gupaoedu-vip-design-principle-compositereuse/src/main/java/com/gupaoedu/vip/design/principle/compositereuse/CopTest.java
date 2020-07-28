package com.gupaoedu.vip.design.principle.compositereuse;

/**
 * Created by Tom on 2020/2/17.
 */
public class CopTest {
    public static void main(String[] args) {
        ProductDao productDao = new ProductDao();
        productDao.setConnection(new MySQLConnection());
        productDao.addProduct();
    }
}
