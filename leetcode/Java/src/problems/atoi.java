package problems;

/**
 * Created by Martin on 09/02/2016.
 */
public class atoi {
    /**
     * Atoi in C++
     * @param str
     * @return
     */
    public int myAtoi(String str) {
        //Problem 8
        if (str == null) return 0;
        int i = 0;
        boolean sign = true;
        str = str.trim();
        int n = str.length();
        if (i < n && (str.charAt(0) == '+' || str.charAt(0) == '-')) {
            if (str.charAt(0) == '+') sign = true;
            else sign = false;
            ++i;
        }
        int res = 0;
        while (i < n && Character.isDigit(str.charAt(i))) {
            if(res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > Integer.MAX_VALUE % 10)){
                return sign ? Integer.MAX_VALUE : Integer.MIN_VALUE ;
            }
            res = res * 10 + str.charAt(i) - 48;
            ++i;
        }
        return sign ? res : -res;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
}
