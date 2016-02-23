package IntegerArray;

/**
 * Created by Martin on 22/02/2016.
 */
public class removeElement {
    /**
     *
     * Given an array [0,4,4,0,0,2,4,4], value=4
     * return 4 and front four elements of the array is [0,0,0,2]
     *
     *@param A: A list of integers
     *@param elem: An integer
     *@return: The new length after remove
     */
    public int removeElement(int[] A, int elem) {
        // write your code here
        if(A.length == 0 || A == null)
            return 0;
        int i = 0;
        int j = 0;

        while (j < A.length) {
            if (A[j] != elem) {
                A[i] = A[j];
                i++;
            }
            j++;
        }
        return i;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }
}
