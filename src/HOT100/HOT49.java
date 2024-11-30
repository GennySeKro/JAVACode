package HOT100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class HOT49 {
    /*
    字母异位词分组
     */

    public List<List<String>> groupAnagrams(String[] strs) {
        ArrayList<List<String>> res = new ArrayList<>();

        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = buildString(chars);
            List<String> temp;
            if (map.containsKey(key)){
                temp = map.get(key);
            }else {
                temp = new ArrayList<>();
            }
            temp.add(str);
            map.put(key, temp);
        }

        return new ArrayList<List<String>>(map.values());
    }

    private String buildString(char[] chars) {
        StringBuilder res = new StringBuilder();
        for (char c : chars){
            res.append(c);
        }
        return res.toString();
    }

    @Test
    public void test(){
        System.out.println(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }
}
