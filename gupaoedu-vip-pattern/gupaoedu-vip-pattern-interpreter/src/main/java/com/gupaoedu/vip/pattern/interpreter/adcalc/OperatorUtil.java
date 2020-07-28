package com.gupaoedu.vip.pattern.interpreter.adcalc;

import java.util.Stack;

/**
 * Created by Tom.
 */
public class OperatorUtil {

    public static Interpreter getInterpreter(Stack<IArithmeticInterpreter> numStack, Stack<String> operatorStack) {
        IArithmeticInterpreter right = numStack.pop();
        IArithmeticInterpreter left = numStack.pop();
        String symbol = operatorStack.pop();
        System.out.println("数字出栈：" + right.interpret() + "," + left.interpret() + ",操作符出栈:" + symbol);
        if (symbol.equals("+")) {
            return new AddInterpreter(left, right);
        } else if (symbol.equals("-")) {
            return new SubInterpreter(left, right);
        } else if (symbol.equals("*")) {
            return new MultiInterpreter(left, right);
        } else if (symbol.equals("/")) {
            return new DivInterpreter(left, right);
        }
        return null;
    }
}
