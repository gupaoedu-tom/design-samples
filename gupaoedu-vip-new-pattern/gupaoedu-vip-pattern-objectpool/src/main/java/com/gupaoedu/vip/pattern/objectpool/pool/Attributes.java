package com.gupaoedu.vip.pattern.objectpool.pool;

public class Attributes {
    private int minCount;
    private int maxCount;
    public Attributes(int maxCount, int minCount) {
        this.maxCount = maxCount;
        this.minCount = minCount;
    }

    public int getMinCount() {
        return minCount;
    }

    public void setMinCount(int minCount) {
        this.minCount = minCount;
    }

    public int getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(int maxCount) {
        this.maxCount = maxCount;
    }
}
