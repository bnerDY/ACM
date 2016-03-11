package problems;

/**
 * Created by Martin on 10/03/2016.
 */
public class triangle {
    /**
     Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

     For example, given the following triangle
     [
     [2],
     [3,4],
     [6,5,7],
     [4,1,8,3]
     ]
     The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
     * @param triangle
     * @return
     */

    public int minimumTotal(int[][] triangle) {
        //2-pass DP
        if (triangle == null || triangle.length == 0) {
            return -1;
        }
        if (triangle[0] == null || triangle[0].length == 0) {
            return -1;
        }

        // state: f[x][y] = minimum path value from x,y to bottom
        int n = triangle.length;
        int[][] f = new int[n][n];

        // initialize
        for (int i = 0; i < n; i++) {
            f[n - 1][i] = triangle[n - 1][i];
        }

        // bottom up
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                f[i][j] = Math.min(f[i + 1][j], f[i + 1][j + 1]) + triangle[i][j];
            }
        }

        // answer
        return f[0][0];
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
}
