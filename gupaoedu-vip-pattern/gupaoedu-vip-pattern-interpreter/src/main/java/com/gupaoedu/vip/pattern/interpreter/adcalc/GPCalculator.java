package com.gupaoedu.vip.pattern.interpreter.adcalc;

import java.util.Stack;

/**
 * 四则运算
 */
public class GPCalculator {

    //数字stack
    private Stack<IArithmeticInterpreter> numStack = new Stack<IArithmeticInterpreter>();
    //操作符stack
    private Stack<String> operatorStack = new Stack<String>();
    /**
     * 解析表达式
     * @param expression
     */
    public GPCalculator(String expression) {
        this.parse(expression);
    }

    private void parse(String input) {
        //对表达式去除空字符操作
        String expression = this.fromat(input);
        System.out.println("标准表达式：" + expression);
        for (String s : expression.split(" ")) {
            if (s.length() == 0){
                //如果是空格的话就继续循环，什么也不操作
                continue;
            }
            //如果是加减的话，因为加减的优先级最低，因此这里的只要遇到加减号，无论操作符栈中的是什么运算符都要运算
            else if (s.equals(OperatorEnum.ADD.getOperator())
                    || s.equals(OperatorEnum.SUB.getOperator())) {
                //当栈不是空的，并且栈中最上面的一个元素是加减乘除的人任意一个
                while (!operatorStack.isEmpty()
                        &&(operatorStack.peek().equals(OperatorEnum.SUB.getOperator())
                        || operatorStack.peek().equals(OperatorEnum.ADD.getOperator())
                        || operatorStack.peek().equals(OperatorEnum.MULTI.getOperator())
                        || operatorStack.peek().equals(OperatorEnum.DIV.getOperator()))) {
                    //结果压入栈中
                    numStack.push(OperatorUtil.getInterpreter(numStack,operatorStack));
                }
                //运算完之后将当前的运算符入栈
                System.out.println("操作符入栈:"+s);
                operatorStack.push(s);
            }
            //当前运算符是乘除的时候，因为优先级高于加减，因此要判断最上面的是否是乘除，如果是乘除就运算，否则的话直接入栈
            else if (s.equals(OperatorEnum.MULTI.getOperator())
                    || s.equals(OperatorEnum.DIV.getOperator())) {
                while (!operatorStack.isEmpty()&&(
                        operatorStack.peek().equals(OperatorEnum.MULTI.getOperator())
                        || operatorStack.peek().equals(OperatorEnum.DIV.getOperator()))) {
                    numStack.push(OperatorUtil.getInterpreter(numStack,operatorStack));
                }
                //将当前操作符入栈
                System.out.println("操作符入栈:"+s);
                operatorStack.push(s);
            }
            //如果是左括号的话直接入栈，什么也不用操作,trim()函数是用来去除空格的，由于上面的分割操作可能会令操作符带有空格
            else if (s.equals(OperatorEnum.LEFT_BRACKET.getOperator())) {
                System.out.println("操作符入栈:"+s);
                operatorStack.push(OperatorEnum.LEFT_BRACKET.getOperator());
            }
            //如果是右括号的话，清除栈中的运算符直至左括号
            else if (s.equals(OperatorEnum.RIGHT_BRACKET.getOperator())) {
                while (!OperatorEnum.LEFT_BRACKET.getOperator().equals(operatorStack.peek())) {
                    //开始运算
                    numStack.push(OperatorUtil.getInterpreter(numStack,operatorStack));
                }
                //这里的是运算完之后清除左括号
                String pop = operatorStack.pop();
                System.out.println("括号运算操作完成，清除栈中右括号："+pop);
            }
            //这里如果是数字的话直接如数据的栈
            else {
                //将数字字符串转换成数字然后压入栈中
                NumInterpreter numInterpreter = new NumInterpreter(Integer.valueOf(s));
                System.out.println("数字入栈："+s);
                numStack.push(numInterpreter);
            }
        }
        //最后当栈中不是空的时候继续运算，知道栈中为空即可
        while (!operatorStack.isEmpty()) {
            numStack.push(OperatorUtil.getInterpreter(numStack,operatorStack));
        }
    }

    /**
     * 计算结果出栈
     * @return
     */
    public int calculate() {
        return this.numStack.pop().interpret();
    }

    /**
     * 换成标准形式，便于分割
     * @param expression
     * @return
     */
    private String fromat(String expression) {
        String result = "";
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '(' || expression.charAt(i) == ')' ||
                expression.charAt(i) == '+' || expression.charAt(i) == '-' ||
                expression.charAt(i) == '*' || expression.charAt(i) == '/')
                //在操作符两个增加一个空格
                result += (" " + expression.charAt(i) + " ");
            else
                result += expression.charAt(i);
        }
        return result;
    }
}

