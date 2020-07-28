package com.gupaoedu.vip.design.principle.compositereuse;

/**
 * Created by Tom on 2020/2/17.
 */
public class ProductDao {
    private DBConnection dbConnection;
    public void setConnection(DBConnection dbConnection){
        this.dbConnection = dbConnection;
    }
    public void addProduct(){
        String conn = dbConnection.getConnection();
        System.out.println("获得数据库连接");
    }
}
