package com.gupaoedu.vip.pattern.interpreter.calculate;

/**
 * Created by Tom.
 */
public class OperatorUtil {
    public static boolean ifOperator(String symbol){
        return (symbol.equals("+") || symbol.equals("-") || symbol.equals("*") || symbol.equals("/"));
    }

    public static Interpreter getInterpreter(IArithmeticInterpreter left,IArithmeticInterpreter right,String symbol){
        if(symbol.equals("+")){
            return new AddInterpreter(left,right);
        }else if(symbol.equals("-")){
            return new SubInterpreter(left,right);
        }else if(symbol.equals("*")){
            return new MultilInterpreter(left,right);
        }else if(symbol.equals("/")){
            return new DivInterpreter(left,right);
        }
        return null;
    }
}
