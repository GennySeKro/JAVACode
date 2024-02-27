package LCR;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LCR065 {
    /*
    单词的压缩编码
     */

    public int minimumLengthEncoding(String[] words) {
        Set<String> set = new HashSet<String>(Arrays.asList(words));
        for (String word : words){
            for (int i = 1;i < word.length();i++){
                set.remove(word.substring(i));
            }
        }
        int ans = 0;
        for (String word : set){
            ans = ans + word.length() + 1;
        }
        return ans;
    }
}
