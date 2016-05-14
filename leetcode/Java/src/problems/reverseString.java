package problems;

/**
 * Created by Martin on 14/05/2016.
 */
public class reverseString {
    /**
     * Write a function that takes a string as input and returns the string reversed.
     * Example:
     * Given s = "hello", return "olleh".
     */
    public class Solution {
        public String reverseString(String s) {
            String res = new StringBuilder(s).reverse().toString();
            return res;
        }
    }
}
