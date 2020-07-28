package com.gupaoedu.vip.pattern.chain.auth.builderchain;


import com.gupaoedu.vip.pattern.chain.auth.Member;

/**
 * Created by Tom.
 */
public class MemberService {

    public void login(String loginName,String loginPass){

       Handler.Builder builder = new Handler.Builder();

       builder.addHandler(new ValidateHandler())
               .addHandler(new LoginHandler())
               .addHandler(new AuthHandler());

       builder.build().doHandler(new Member(loginName,loginPass));

    }

}
