package com.gupaoedu.vip.pattern.strategy.general;

/**
 * Created by Tom.
 */
public class Client {
    public static void main(String[] args) {
        //选择一个具体策略
        IStrategy strategy = new ConcreteStrategyA();
        //来一个上下文环境
        Context context = new Context(strategy);
        //客户端直接让上下文环境执行算法
        context.algorithm();
    }

    //抽象策略类 Strategy
    interface IStrategy {
        void algorithm();
    }

    //上下文环境
    static class Context {
        private IStrategy strategy;

        public Context(IStrategy strategy) {
            this.strategy = strategy;
        }

        public void algorithm() {
            this.strategy.algorithm();
        }
    }

    //具体策略类 ConcreteStrategyA
    static class ConcreteStrategyA implements IStrategy {
        public void algorithm() {
            System.out.println("Strategy A");
        }
    }

    //具体策略类 ConcreteStrategyB
    static class ConcreteStrategyB implements IStrategy {
        public void algorithm() {
            System.out.println("Strategy B");
        }
    }
}
