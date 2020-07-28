package com.gupaoedu.vip.pattern.interpreter.calculate;

/**
 * 减法
 * Created by Tom.
 */
public class SubInterpreter extends Interpreter {
    public SubInterpreter(IArithmeticInterpreter left, IArithmeticInterpreter right) {
        super(left, right);
    }

    public int interpret() {
        return this.left.interpret() - this.right.interpret();
    }
}
