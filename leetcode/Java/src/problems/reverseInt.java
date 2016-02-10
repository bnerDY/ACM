package problems;

/**
 * Created by Martin on 09/02/2016.
 */
public class reverseInt {
    /**
     * Reverse digits of an integer.
     * Example1: x = 123, return 321
     * Example2: x = -123, return -321
     * @param x
     * @return
     */
    public int reverseInt(int x) {
        //problem 7
        long res = 0;
        long input_long = x;
        while (input_long != 0) {
            res = res * 10 + input_long % 10;
            input_long = input_long / 10;
        }

        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
}
