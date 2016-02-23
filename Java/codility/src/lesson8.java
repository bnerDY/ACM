import java.util.HashMap;
import java.util.Map;

/**
 * Created by Martin on 15/11/2015.
 */
public class lesson8 {
    //Leader
    /**
     * For example, consider array A such that
     * A[0] = 3    A[1] = 4    A[2] =  3
     * A[3] = 2    A[4] = 3    A[5] = -1
     * A[6] = 3    A[7] = 3
     * The dominator of A is 3 because it occurs in 5 out of 8 elements of A
     * (namely in those with indices 0, 2, 4, 6 and 7) and 5 is more than a half of 8.
     *
     * @param A
     * @return
     */

    public static int dominator(int[] A) {
        //hashmap solution.
        int res = -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(A[i])) {
                map.put(A[i], map.get(A[i]) + 1);
            } else {
                map.put(A[i], 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > A.length / 2) {
                return entry.getKey();
            }
        }
        return res;

    }

    public static void main(String[] args) {
        int[] A = {3, 4, 3, 2, 3, -1, 3, 3};
        System.out.println(dominator(A));
    }
}
