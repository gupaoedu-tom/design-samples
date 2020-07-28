package com.gupaoedu.vip.design.principle.simpleresponsibility.method;

/**
 * Created by Tom on 2020/2/16.
 */
public class Method {

    private void modifyUserInfo(String userName,String address){
        userName = "Tom";
        address = "Changsha";
    }

    private void modifyUserInfo(String userName,String ... fileds){

    }

    private void modifyUserInfo(String userName,String address,boolean bool){
        if(bool){

        }else{

        }
    }

    private void modifyUserName(String userName){

    }

    private void modifyAddress(String address){

    }
}
