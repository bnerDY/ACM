package problems;

import java.util.LinkedList;

/**
 * Created by Martin on 03/03/2016.
 */
public class EvaluateReversePolishNotation {

    /**
     * Problem 150
     * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
     * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
     Some examples:
     ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
     ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
     * @param tokens
     * @return
     */

    public static int evalRPN(String[] tokens) {
        //can be optimization
        int res;
        LinkedList<String> stack = new LinkedList<>();
        for (int i = 0; i <tokens.length ; i++) {
            if (tokens[i].equals("+")){
                int value1 = Integer.parseInt(stack.pop());
                int value2 = Integer.parseInt(stack.pop());
                res = value1 + value2;
                stack.push(String.valueOf(res));
            }else if(tokens[i].equals("-")){
                int value1 = Integer.parseInt(stack.pop());
                int value2 = Integer.parseInt(stack.pop());
                res = value2 - value1;
                stack.push(String.valueOf(res));
            }else if(tokens[i].equals("*")) {
                int value1 = Integer.parseInt(stack.pop());
                int value2 = Integer.parseInt(stack.pop());
                res = value1 * value2;
                stack.push(String.valueOf(res));
            }else if(tokens[i].equals("/")) {
                int value1 = Integer.parseInt(stack.pop());
                int value2 = Integer.parseInt(stack.pop());
                res = value2 / value1;
                stack.push(String.valueOf(res));
            }
            else{
                stack.push(tokens[i]);
            }
        }
        res = Integer.valueOf(stack.pop());
        return res;
    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String[] test = {"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(test));
    }
}
