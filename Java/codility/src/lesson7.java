import java.util.LinkedList;

/**
 * Created by Martin on 15/11/2015.
 */
public class lesson7 {
    //Stack and Queues.
    /**
     * A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:
     * S is empty;
     * S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
     * S has the form "VW" where V and W are properly nested strings.
     * For example, the string "{[()()]}" is properly nested but "([)()]" is not.

     * @param S
     * @return
     */

    public static int brackets(String S) {
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return 0;
                }
                char corresponding = stack.pop();
                if (c == ')' && corresponding != '(') {
                    return 0;
                }
                if (c == ']' && corresponding != '[') {
                    return 0;
                }
                if (c == '}' && corresponding != '{') {
                    return 0;
                }
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }

    public static void main(String[] args) {
        System.out.println(brackets("{[()()]}"));
        System.out.println(brackets("([)()]"));

    }
}
