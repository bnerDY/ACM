package String;

/**
 * Created by Martin on 22/02/2016.
 */
public class compareStrings {

    /**
     * Example
     * For A = "ABCD", B = "ACD", return true.
     * For A = "ABCD", B = "AABC", return false.
     * @param A : A string includes Upper Case letters
     * @param B : A string includes Upper Case letter
     * @return :  if string A contains all of the characters in B return true else return false
     */

    public static boolean compareStrings(String A, String B) {
        // write your code here
        if (A.length() == 0){
            return B.length() == 0;
        }
        int[] count = new int[26];

        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);
            count[c - 'A'] += 1;
//            System.out.println(Arrays.toString(count));
        }

        for (int i = 0; i < B.length(); i++) {
            char c = B.charAt(i);
            count[c - 'A'] -= 1;
            if (count[c - 'A'] < 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(compareStrings("ABC", "BC"));

    }
}
