package com.gupaoedu.vip.pattern.strategy.promotion;

/**
 * Created by Tom.
 */
public class CashbackStrategy implements IPromotionStrategy {
    public void doPromotion() {
        System.out.println("返现，直接打款到支付宝账号");
    }
}
