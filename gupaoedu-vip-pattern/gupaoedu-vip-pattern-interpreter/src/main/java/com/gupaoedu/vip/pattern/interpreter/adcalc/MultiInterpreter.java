package com.gupaoedu.vip.pattern.interpreter.adcalc;

/**
 * 乘法
 * Created by Tom.
 */
public class MultiInterpreter extends Interpreter {
    public MultiInterpreter(IArithmeticInterpreter left, IArithmeticInterpreter right) {
        super(left, right);
    }

    public int interpret() {
        return this.left.interpret() * this.right.interpret();
    }
}
