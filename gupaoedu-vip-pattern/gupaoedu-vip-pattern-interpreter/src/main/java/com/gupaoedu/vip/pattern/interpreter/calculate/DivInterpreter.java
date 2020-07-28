package com.gupaoedu.vip.pattern.interpreter.calculate;

/**
 * 除法
 * Created by Tom.
 */
public class DivInterpreter extends Interpreter {
    public DivInterpreter(IArithmeticInterpreter left, IArithmeticInterpreter right) {
        super(left, right);
    }

    public int interpret() {
        return this.left.interpret() / this.right.interpret();
    }
}
