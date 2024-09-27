package SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class S1297 {
    /*
    子串的最大出现次数
     */

    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        HashMap<String, Integer> countMap = new HashMap<>();
        for (int i = 0;i < s.length();i++){
            if (i + minSize > s.length()){
                break;
            }
            String sub = s.substring(i, i + minSize);
            if (isMatch(sub, maxLetters)){
                countMap.put(sub, countMap.getOrDefault(sub, 0) + 1);
            }
        }

        int res = 0;
        for (String str : countMap.keySet()){
            res = Math.max(res, countMap.get(str));
        }

        return res;

    }

    private boolean isMatch(String str, int maxLetters){
        Set<Character> set = new HashSet<>();
        for (char c : str.toCharArray()){
            set.add(c);
            if (set.size() > maxLetters){
                return false;
            }
        }
        return true;
    }
}
