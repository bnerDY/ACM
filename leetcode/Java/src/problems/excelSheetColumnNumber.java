package problems;

/**
 * Created by Martin on 09/02/2016.
 */
public class excelSheetColumnNumber {
    /**
     * Given a column title as appear in an Excel sheet, return its corresponding column number.
     * For example:
     * A -> 1
     * B -> 2
     * C -> 3
     * ...
     * Z -> 26
     * AA -> 27
     * AB -> 28
     * @param s
     * @return
     */
    public static int titleToNumber(String s) {
        //problem 171
        if (s == null || s.isEmpty()) return 0; // invalid input
        char[] chars = s.toCharArray();
        int r = 0;
        for (char c : chars) {
            r = r * 26 + (c - 'A') + 1;
        }
        return r;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
}
