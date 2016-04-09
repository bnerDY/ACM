package problems;

/**
 * Created by Martin on 09/04/2016.
 */
public class implementStrstr {
    /**
     * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
     * @param source
     * @param target
     * @return
     */
    public static int strStr(String source, String target) {
        if (source == null || target == null) {
            return -1;
        }

        for (int i = 0; i < source.length() - target.length() + 1; i++) {
            int j = 0;
            for (j = 0; j < target.length(); j++) {
                if (source.charAt(i + j) != target.charAt(j)) {
                    break;
                }
            }
            // finished loop, target found
            if (j == target.length()) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
}
