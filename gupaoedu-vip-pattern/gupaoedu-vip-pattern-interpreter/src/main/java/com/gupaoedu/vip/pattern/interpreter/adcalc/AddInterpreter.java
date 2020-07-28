package com.gupaoedu.vip.pattern.interpreter.adcalc;

/**
 * 加法
 * Created by Tom.
 */
public class AddInterpreter extends Interpreter {
    public AddInterpreter(IArithmeticInterpreter left, IArithmeticInterpreter right) {
        super(left, right);
    }

    public int interpret() {
        return this.left.interpret() + this.right.interpret();
    }
}
