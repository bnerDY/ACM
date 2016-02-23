package String;

/**
 * Created by Martin on 22/02/2016.
 */
public class strstr {
    /**
     * Example
     * If source = "source" and target = "target", return -1.
     * If source = "abcdabcdefg" and target = "bcd", return 1.
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * <p>
     * Check position i+j of source and position j of target. If not match, break out.
     * If j matches target.length(), means target is fully embedded in source.
     * return start point of target in source: i
     *
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */


    public int strStr(String source, String target) {
        //write your code here
        //Check Null
        if (source == null || target == null) {
            return -1;
        }
        //Two Pointer check for target
        int i, j;
        for (i = 0; i < source.length() - target.length() + 1; i++) {
            for (j = 0; j < target.length(); j++) {
                if (source.charAt(i + j) != target.charAt(j)) {
                    break;
                }
            }
            if (j == target.length()) {
                return i;
            }
        }
        //'target' not found:
        return -1;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }
}
