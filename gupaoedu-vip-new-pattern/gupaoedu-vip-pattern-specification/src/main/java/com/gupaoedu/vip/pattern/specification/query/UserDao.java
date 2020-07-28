package com.gupaoedu.vip.pattern.specification.query;

import java.util.ArrayList;

public class UserDao {

    //用户列表
    private ArrayList<User> userList;

    //构造函数传递用户列表
     public UserDao(ArrayList<User> _userList) {
        this.userList = _userList;
    }

    //年龄大于指定年龄的用户
    public ArrayList<User> findUserByAgeThan(int age) {
        ArrayList<User> result = new ArrayList<User>();
        for (User u : userList) {
            if (u.getAge() > age) { //符合条件的用户
                result.add(u);
            }
        }
        return result;
    }

    //姓名等于指定姓名的用户
    public ArrayList<User> findUserByNameEqual(String name) {
        ArrayList<User> result = new ArrayList<User>();
        for (User u : userList) {
            if (u.getName().equals(name)) {//符合条件
                result.add(u);
            }
        }
        return result;
    }

}