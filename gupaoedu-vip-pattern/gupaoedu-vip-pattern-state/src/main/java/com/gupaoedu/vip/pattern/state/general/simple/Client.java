package com.gupaoedu.vip.pattern.state.general.simple;

/**
 * Created by Tom.
 */
public class Client {
    public static void main(String[] args) {
        Context context = new Context();
        context.setState(new ConcreteStateB());
        context.handle();
    }

    //抽象状态：State
    interface IState {
        void handle();
    }

    //具体状态类
    static class ConcreteStateA implements IState {
        public void handle() {
            //必要时刻需要进行状态切换
            System.out.println("StateA do action");
        }
    }

    //具体状态类
    static class ConcreteStateB implements IState {
        public void handle() {
            //必要时刻需要进行状态切换
            System.out.println("StateB do action");
        }
    }

    //环境类
    static class Context {
        private static final IState STATE_A = new ConcreteStateA();
        private static final IState STATE_B = new ConcreteStateB();
        //默认状态A
        private IState currentState = STATE_A;

        public void setState(IState state) {
            this.currentState = state;
        }

        public void handle() {
            this.currentState.handle();
        }
    }
}
