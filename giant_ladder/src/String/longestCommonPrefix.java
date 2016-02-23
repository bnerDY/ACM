package String;

/**
 * Created by Martin on 22/02/2016.
 */
public class longestCommonPrefix {
    /**
     *
     * For strings "ABCD", "ABEF" and "ACEF", the LCP is "A"
     * For strings "ABCDEFG", "ABCEFG" and "ABCEFA", the LCP is "ABC"
     * @param strs: A list of strings
     * @return: The longest common prefix
     */
    public String longestCommonPrefix(String[] strs) {
        // write your code here
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for(int i = 1; i < strs.length; i++) {
            int j = 0;
            while( j < strs[i].length() && j < prefix.length() && strs[i].charAt(j) == prefix.charAt(j)) {
                j++;
            }
            if( j == 0) {
                return "";
            }
            prefix = prefix.substring(0, j);
        }
        return prefix;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }
}
