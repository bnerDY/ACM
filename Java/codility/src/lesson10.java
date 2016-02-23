/**
 * Created by Martin on 15/11/2015.
 */
public class lesson10 {
    // Prime and composite numbers.
    /**
     * A positive integer D is a factor of a positive integer N
     * if there exists an integer M such that N = D * M.
     * For example, 6 is a factor of 24, because M = 4 satisfies
     * the above condition (24 = 6 * 4).
     *
     * @param N
     * @return
     */
    public static int countFactors(int N) {
//        O(n) for solution below.
//        int res = 0;
//        int start = 1;
//        while(start <= N){
//            if(N % start == 0){
//                res ++;
//            }
//            start++;
//        }
//        return res;


//        O(logN)
        int numFactors = 0;
        for (int i = 1; i <= Math.sqrt(N); i++) {

            if (N % i == 0 && i * i != N) {
                numFactors = numFactors + 2;
            } else if (N % i == 0 && i * i == N) {
                numFactors = numFactors + 1;
            }
        }

        return numFactors;

    }

    public static void main(String[] args) {
        System.out.println(countFactors(24));
    }
}
