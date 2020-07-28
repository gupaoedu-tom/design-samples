package com.gupaoedu.vip.pattern.state.general.apply;

/**
 * Created by Tom.
 */
public class Client {
    public static void main(String[] args) {
        Context context = new Context();
        context.setState(new ConcreteStateA());
        context.handle();
    }

    // 抽象状态：State
    static abstract class State {
        protected Context context;

        public void setContext(Context context) {
            this.context = context;
        }

        public abstract void handle();
    }

    //具体状态类A
    static class ConcreteStateA extends State {
        @Override
        public void handle() {
            System.out.println("StateA do action");
            // A状态完成后自动切换到B状态
            this.context.setState(Context.STATE_B);
            this.context.getState().handle();
        }
    }

    //具体状态类B
    static class ConcreteStateB extends State {
        @Override
        public void handle() {
            System.out.println("StateB do action");
        }
    }

    //环境类
    static class Context {
        public static final State STATE_A = new ConcreteStateA();
        public static final State STATE_B = new ConcreteStateB();
        // 默认状态A
        private State currentState = STATE_A;
        {
            STATE_A.setContext(this);
            STATE_B.setContext(this);
        }

        public void setState(State state) {
            this.currentState = state;
            this.currentState.setContext(this);
        }

        public State getState() {
            return this.currentState;
        }

        public void handle() {
            this.currentState.handle();
        }
    }
}
