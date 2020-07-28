package com.gupaoedu.vip.pattern.strategy.promotion;

/**
 * Created by Tom.
 */
public class Test {
    public static void main(String[] args) {
        String promotion = "";
//        IPromotionStrategy strategy = null;

//        PromotionActivity activity = new PromotionActivity(new GroupbuyStrategy());
//        activity.execute();
        PromotionStrategyFacory.getPromotionKeys();
        String promotionKey = "COUPON";

        IPromotionStrategy promotionStrategy = PromotionStrategyFacory.getPromotionStrategy(promotionKey);
        promotionStrategy.doPromotion();
    }
}
