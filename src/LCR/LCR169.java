package LCR;

import java.util.HashMap;
import java.util.Map;

public class LCR169 {
    /*
    招式拆解Ⅱ
     */

    public char dismantlingAction(String arr) {
        Map<Character, Integer> map = new HashMap<>();
        int[] num = new int[26];
        for (int i = 0;i < arr.length();i++){
            if (!map.containsKey(arr.charAt(i))){
                map.put(arr.charAt(i), i);
            }
            num[arr.charAt(i) - 'a']++;
        }
        char res = ' ';
        int index = Integer.MAX_VALUE;
        for (int i = 0;i < 26;i++){
            if (num[i] == 1){
                if (map.get((char)(i + 'a')) < index){
                    index = map.get((char)(i + 'a'));
                    res = (char)(i + 'a');
                }
            }
        }
        return res;
    }
}
