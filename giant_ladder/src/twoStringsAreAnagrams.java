import java.util.Arrays;

/**
 * Created by Martin on 22/02/2016.
 */
public class twoStringsAreAnagrams {

    /**
     * @param s: The first string
     * @param t: The second string
     * @return true or false
     */
    public static boolean anagram(String s, String t) {
        // write your code here
        if(s.length() != t.length()){
            return false;
        }
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();

        Arrays.sort(ss);
        Arrays.sort(tt);

        if (Arrays.equals(ss,tt)) {
            return true;
        } else {
            return false;
        }
    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(anagram("abc", "cba"));
    }
}
