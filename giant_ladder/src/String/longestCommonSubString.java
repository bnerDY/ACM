package String;

/**
 * Created by Martin on 22/02/2016.
 */
public class longestCommonSubString {
    /**
     * Example
     * Given A = "ABCD", B = "CBCE", return 2.
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
        // write your code here
        int max = 0;
        int[][] d = new int[A.length()+1][B.length()+1];

        for (int i = 0; i < A.length(); i++) {
            for (int j = 0; j < B.length(); j++) {
                if (A.charAt(i) == B.charAt(j)) {
                    d[i+1][j+1] = d[i][j] + 1;
                    max = Math.max(max, d[i+1][j+1]);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }
}
