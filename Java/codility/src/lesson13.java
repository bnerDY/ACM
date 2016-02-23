import java.util.ArrayList;

/**
 * Created by Martin on 15/11/2015.
 */
public class lesson13 {
    // Fibonacci numbers. Binary Recursion.
    // Not fully solved.

    /**
     * The leaves on the river are represented in a zero-indexed array A consisting of N integers. Consecutive elements of array A represent consecutive positions from 0 to N − 1 on the river. Array A contains only 0s and/or 1s:
     * <p>
     * 0 represents a position without a leaf;
     * 1 represents a position containing a leaf.
     * The goal is to count the minimum number of jumps in which the frog can get to the other side of the river (from position −1 to position N). The frog can jump between positions −1 and N (the banks of the river) and every position containing a leaf.
     * <p>
     * For example, consider array A such that:
     * <p>
     * A[0] = 0
     * A[1] = 0
     * A[2] = 0
     * A[3] = 1
     * A[4] = 1
     * A[5] = 0
     * A[6] = 1
     * A[7] = 0
     * A[8] = 0
     * A[9] = 0
     * A[10] = 0
     * The frog can make three jumps of length F(5) = 5, F(3) = 2 and F(5) = 5.
     *
     * @param A
     * @return
     */
    public static int fibFrog(int[] A) {
        int N = A.length;
        int[] fib = new int[N + 4];
        boolean[] visit = new boolean[N];
        fib[0] = 0;
        fib[1] = 1;
        int m = 1;
        do {
            m++;
            fib[m] = fib[m - 1] + fib[m - 2];
        } while (fib[m] <= N + 1);
        ArrayList<Status> statusQueue = new ArrayList<Status>();
        // use a queue to save the position and the moves of every possible jump
        statusQueue.add(new Status(-1, 0));
        int nextTry = 0;
        // use the breadth first search to get the result
        while (true) {
            if (nextTry == statusQueue.size())
                return -1;
            Status currStatus = statusQueue.get(nextTry);
            nextTry++;
            int currPosition = currStatus.position;
            int currMoves = currStatus.moves;
            for (int i = m - 1; i > 0; i--) {
                if (currPosition + fib[i] == N)
                    return currMoves + 1;
                else if (currPosition + fib[i] > N ||
                        A[currPosition + fib[i]] == 0 ||
                        visit[currPosition + fib[i]] == true)
                    continue;
                statusQueue.add(new Status(currPosition + fib[i], currMoves + 1));
                visit[currPosition + fib[i]] = true;
            }
        }
    }

    public static void main(String[] args) {

    }
}

class Status {
    public int position;
    public int moves;

    public Status(int p, int m) {
        position = p;
        moves = m;
    }
}