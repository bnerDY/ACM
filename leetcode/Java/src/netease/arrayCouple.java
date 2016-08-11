package netease;

import java.util.Scanner;

/**
 * Created by Martin on 02/08/2016.
 */
public class arrayCouple {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int r = in.nextInt();
        int l = in.nextInt();
        int res = 0;
        int i = 0;
        while (i < r) {
            String t = in.nextLine();
            char[] tchar = t.toCharArray();
            for (int j = 0; j < l; j++) {
                if (tchar[j] == 0) {
                    res++;
                }
            }
            i++;
        }
        System.out.println(res);
    }
}
