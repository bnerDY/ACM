package netease;

import java.util.Scanner;

/**
 * Created by Martin on 02/08/2016.
 */
public class dp {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        in.nextLine();
        int k = in.nextInt();
        int d = in.nextInt();

        int res = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < d; j++) {
                res = Math.max(res, arr[i] * arr[j]);
            }
        }
        System.out.println(res);
    }

}
