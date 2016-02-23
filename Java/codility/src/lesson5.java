/**
 * Created by Martin on 15/11/2015.
 */
public class lesson5 {

    //Prefix Sums.
    /**
     * Given three integers A, B and K,
     * returns the number of integers within the range [A..B] that
     * are divisible by K, i.e.:
     * { i : A ≤ i ≤ B, i mod K = 0 }
     * For example, for A = 6, B = 11 and K = 2, your function
     * should return 3, because there are three numbers divisible
     * by 2 within the range [6..11], namely 6, 8 and 10.
     * @param A
     * @param B
     * @param K
     * @return
     */


    public static int countDiv(int A, int B, int K) {
        // write your code in Java SE 8
//        poor complexity
//        int res = 0;
//        if(K == 0) {
//            return (-1);
//        }
//        if(K > B) {
//            return 0;
//        }
//        while (A < B) {
//            if (A % K == 0) {
//                res += 1;
//            }
//            A++;
//        }
//        return res;
        int count = 0;
        int div1 = 0;
        int div2 = 0;
        div1 = A / K;
        div2 = B / K;
        count = div2 - div1;
        if (A % K == 0) count++;
        return count;
    }



    public static void main(String[] args) {
        System.out.println(countDiv(6,11,2));
    }
}
