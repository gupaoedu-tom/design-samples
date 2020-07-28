package com.gupaoedu.vip.pattern.chain.auth.builderchain;

/**
 * Created by Tom.
 */
public class Test {
    public static void main(String[] args) {
        MemberService memberService = new MemberService();
        memberService.login("tom","666");
    }
}
