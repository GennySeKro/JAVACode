package LCR;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class LCR034 {
    /*
    验证外星语词典
     */

    public boolean isAlienSorted(String[] words, String order) {
        // 根据题目给的顺序order制定字典。
        int[] dic = new int[26];
        for (int i = 0; i < order.length(); i++) {
            dic[order.charAt(i) - 'a'] = i;
        }
        // 遍历words。
        for (int i = 0; i < words.length - 1; i++) {
            boolean flag = true;
            // 比较共同长度部分的字符（words[i].length = 3, words[i + 1].length = 5，那就只比3个字母，如果这三个字母都相同，那长度更长的字符串应该排在后面。）
            for (int j = 0; j < words[i].length() && j < words[i + 1].length(); j++) {
                int curr = dic[words[i].charAt(j) - 'a'];
                int next = dic[words[i + 1].charAt(j) - 'a'];
                // 前一个单词的第j个字母比后一个单词的第j个字母大的话，就不符合规则了，不用往下比了，直接false。
                if (curr > next) {
                    return false;
                } else if (curr < next) {
                    flag = false;
                    // 前一个单词的第j个字母比后一个单词的第j个字母小，已经符合规则了，不用接着往下比了，长度也不用比了。
                    break;
                }
                // else curr == next 就接着往下比。直到某一个字符串尾，还没比出结果，就比长度。
            }
            // 判断两个单词的长度。
            if (flag) {
                if (words[i].length() > words[i + 1].length()) {
                    return false;
                }
            }
        }
        return true;
    }

    @Test
    public void test(){
        System.out.println(isAlienSorted(new String[]{"hello","leetcode"}, new String("hlabcdefgijkmnopqrstuvwxyz")));
    }
}
