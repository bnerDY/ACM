package problems;

/**
 * Created by Martin on 09/02/2016.
 */
public class sqrtX {
    /**
     * Binary Search
     * Implement int sqrt(int x).
     * Compute and return the square root of x.
     * @param x
     * @return
     */
    public static int mySqrt(int x) {
        //Problem 69.
        long i = 0;
        long j = x / 2 + 1;
        while (i <= j) {
            long mid = (i + j) / 2; // way for binary
            if (mid * mid == x)
                return (int) mid;
            if (mid * mid < x)
                i = mid + 1;
            else
                j = mid - 1;
        }
        return (int) j;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(mySqrt(2));
    }
}
