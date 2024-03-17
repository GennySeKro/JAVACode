package Leetcode.fortnight.f124;

import org.junit.Test;

import java.util.*;

public class HOT100211 {
    /*
    进行操作使字符串为空
     */

    /*
    暴力循环:超时
     */
    class one{
        public String lastNonEmptyString(String s) {
            List<Character> str = new ArrayList<>();
            for (int i = 0;i < s.length();i++){
                str.add(s.charAt(i));
            }
            List<Character> last = str;
            while (!str.isEmpty()){
                List<Character> res = new ArrayList<>();
                int[] word = new int[26];
                for (int i = 0;i < str.size();i++){
                    if (word[str.get(i) - 'a'] != 0){
                        res.add(str.get(i));
                    }else {
                        word[str.get(i) - 'a'] = 1;
                    }
                }
                last = str;
                str = res;
            }
            StringBuilder k = new StringBuilder();
            for (int i = 0;i < last.size();i++){
                k.append(last.get(i));
            }
            return k.toString();
        }
    }

    /*
    找到出现次数最多的一个几个字母的相对位置，即为结果
     */
    class two{
        public String lastNonEmptyString(String s){
            // 统计字符出现次数和最后出现位置
            Map<Character, Integer> charCount = new HashMap<>();
            int maxCount = 0;

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                charCount.put(c, charCount.getOrDefault(c, 0) + 1);
                maxCount = Math.max(maxCount, charCount.get(c));
            }

            // 找到出现次数最多的字符
            StringBuilder res = new StringBuilder();
            for (int i = s.length() - 1; i >= 0; i--) {
                char c = s.charAt(i);
                if (charCount.get(c) == maxCount && charCount.get(c) != -1) {
                    res.append(c);
                    charCount.put(c, -1);
                }
            }

            return res.reverse().toString();
        }
    }

    @Test
    public void test(){
        System.out.println(new two().lastNonEmptyString("aabcbbca"));
    }
}
