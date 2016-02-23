package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Martin on 22/02/2016.
 */
public class anagrams {
    /**
     *
     * Given ["lint", "intl", "inlt", "code"], return ["lint", "inlt", "intl"].
     * Given ["ab", "ba", "cd", "dc", "e"], return ["ab", "ba", "cd", "dc"].
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public List<String> anagrams(String[] strs) {
        // write your code here
        HashMap<String, ArrayList<String>> record = new HashMap<>();
        List<String> res = new ArrayList<String>();

        for(String s : strs){
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String newWord = new String(arr);
            if(!record.containsKey(newWord)){
                record.put(newWord, new ArrayList<String>());
            }
            record.get(newWord).add(s);
        }

        for(String s : record.keySet()){
            if(record.get(s).size() > 1){
                res.addAll(record.get(s));
            }
        }
        return res;
}

    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }
}
