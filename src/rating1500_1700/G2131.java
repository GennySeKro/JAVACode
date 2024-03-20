package rating1500_1700;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class G2131 {
    /*
    连接两字母单词得到的最长回文串
     */

    public int longestPalindrome(String[] words) {
        int totalCount = 0;
        Map<String, Integer> counts = new HashMap<String, Integer>();
        for (String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }
        boolean hasMiddle = false;
        Set<Map.Entry<String, Integer>> entries = counts.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            String word = entry.getKey();
            int count = entry.getValue();
            String reversed = new StringBuffer().append(word.charAt(1)).append(word.charAt(0)).toString();
            if (word.equals(reversed)) {
                if (count % 2 != 0) {
                    hasMiddle = true;
                }
                totalCount += count / 2 * 2;
            } else if (word.compareTo(reversed) < 0) {
                int countReversed = counts.getOrDefault(reversed, 0);
                totalCount += Math.min(count, countReversed) * 2;
            }
        }
        if (hasMiddle) {
            totalCount++;
        }
        return totalCount * 2;
    }
}
