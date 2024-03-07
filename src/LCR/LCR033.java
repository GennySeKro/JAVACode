package LCR;
import org.junit.Test;

import java.util.*;

public class LCR033 {
    /*
    字母异位词分组
     */

    /*
    时间复杂度O(n * klogk) -- n是strs的长度，k是strs 中的字符串的的最大长度
    空间复杂度O(n * k)
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs.length == 0){
            return res;
        }

        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0;i < strs.length;i++){
            char[] temp = strs[i].toCharArray();
            String str = strs[i];
            Arrays.sort(temp);
            if (map.containsKey(String.valueOf(temp))){
                map.get(String.valueOf(temp)).add(strs[i]);
            }else {
                map.put(String.valueOf(temp),new ArrayList<>(){{
                    add(str);
                }});
            }
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()){
            res.add(entry.getValue());
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }
}
