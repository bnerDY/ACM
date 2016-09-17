package problems;

/**
 * Created by Martin on 17/09/2016.
 */
public class excelSheetColumnTitle {

    public String convertToTitle(int n) {
        return n == 0 ? "" : convertToTitle(--n/26) + (char)('A'+n%26);
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println((char)('A' + 1%26));
        System.out.println(2%26);
    }
}
