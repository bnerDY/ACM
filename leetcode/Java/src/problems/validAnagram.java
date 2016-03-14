package problems;

import java.util.Arrays;

/**
 * Created by Martin on 14/03/2016.
 */
public class validAnagram {
//    Better solution
//    public boolean isAnagram(String s, String t) {
//        if (s == null || t == null || s.length() != t.length()) {
//            return false;
//        }
//        int[] letters = new int[26];
//        for (int i = 0; i < s.length(); i++) {
//            letters[s.charAt(i) - 'a'] += 1;
//            letters[t.charAt(i) - 'a'] -= 1;
//        }
//        for (int i = 0; i < 26; i++) {
//            if (letters[i] != 0) {
//                return false;
//            }
//        }
//        return true;
//    }

    /**
     Given two strings s and t, write a function to determine if t is an anagram of s.

     For example,
     s = "anagram", t = "nagaram", return true.
     s = "rat", t = "car", return false.
     * @param s
     * @param t
     * @return
     */

    public boolean isAnagram(String s, String t) {
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

    }
}
