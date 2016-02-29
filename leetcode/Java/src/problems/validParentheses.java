package problems;

import java.util.LinkedList;

/**
 * Created by Martin on 26/02/2016.
 */
public class validParentheses {

    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char corresponding = stack.pop();
                if (c == ')' && corresponding != '(') {
                    return false;
                }
                if (c == ']' && corresponding != '[') {
                    return false;
                }
                if (c == '}' && corresponding != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty() ? true : false;
    }

//    Alternative solution.
//    public boolean isValid(String s) {
//        Stack<Character> stack = new Stack<Character>();
//        for (Character c : s.toCharArray()) {
//            if ("({[".contains(String.valueOf(c))) {
//                stack.push(c);
//            } else {
//                if (!stack.isEmpty() && is_valid(stack.peek(), c)) {
//                    stack.pop();
//                } else {
//                    return false;
//                }
//            }
//        }
//        return stack.isEmpty();
//    }
//
//    private boolean is_valid(char c1, char c2) {
//        return (c1 == '(' && c2 == ')') || (c1 == '{' && c2 == '}')
//                || (c1 == '[' && c2 == ']');
//    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
}
