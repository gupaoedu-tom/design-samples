package com.gupaoedu.vip.pattern.facade.points;

/**
 * Created by Tom.
 */
public class Test {

    public static void main(String[] args) {

        GiftFacadeService facadeService = new GiftFacadeService();

        GiftInfo giftInfo = new GiftInfo("《Spring 5核心原理》");

        facadeService.exchange(giftInfo);

    }
}
