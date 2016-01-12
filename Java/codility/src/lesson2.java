import java.util.HashMap;
import java.util.Map;

/**
 * Created by Martin on 15/11/2015.
 */
public class lesson2 {
    /**
     * Lesson 2 arrays
     * OddOccurrencesInArray
     *
     * For example, given array A such that:
     * A[0] = 9  A[1] = 3  A[2] = 9
     * A[3] = 3  A[4] = 9  A[5] = 7
     * A[6] = 9
     * the function should return 7, as explained in the example above.
     * the element at index 5 has value 7 and is unpaired.
     *
     */
    public static int OddOccurrencesInArray(int[] A) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : A) {
            if(map.containsKey(n)){
                map.put(n, map.get(n).intValue() + 1);
            }else{
                map.put(n, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if(value % 2 != 0){
                res = entry.getKey();
            }
        }
        return res;
    }

    /**
     * Better solution
     * @param args
     */
//    public int OddOccurrencesInArray(int[] A) {
//        int unpaired = 0;
//        for (int number : A) {
//            unpaired ^= number;
//        }
//        return unpaired;
//    }

    public static void main(String[] args) {
        int[] a = {9, 3, 9, 3, 9, 7, 9};
        System.out.println(OddOccurrencesInArray(a));
    }
}
