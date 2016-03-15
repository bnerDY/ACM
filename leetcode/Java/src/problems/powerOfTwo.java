package problems;

/**
 * Created by Martin on 14/03/2016.
 */
public class powerOfTwo {

    /**
     * Given an integer, write a function to determine if it is a power of two.
     */

    public static boolean isPowerOfTwo(int n) {
        if (n <= 0)
            return false;

        while (n > 2) {
            int t = n >> 1;
            int c = t << 1;

            if (n - c != 0)
                return false;

            n = n >> 1;
        }
        return true;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(isPowerOfTwo(40));
    }
}
