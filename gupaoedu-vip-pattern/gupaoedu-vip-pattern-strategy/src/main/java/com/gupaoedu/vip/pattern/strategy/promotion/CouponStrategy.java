package com.gupaoedu.vip.pattern.strategy.promotion;

/**
 * Created by Tom.
 */
public class CouponStrategy implements IPromotionStrategy {
    public void doPromotion() {
        System.out.println("使用优惠券抵扣");
    }
}
