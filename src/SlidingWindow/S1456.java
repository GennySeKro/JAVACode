package SlidingWindow;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

public class S1456 {
    /*
    定长字串中元音的最大数目
     */

    public int maxVowels(String s, int k) {
        HashSet<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int res = Integer.MIN_VALUE;
        int tempNum = 0;
        for (int i = 0;i < s.length();i++){
            if (i < k){
                if (set.contains(s.charAt(i))){
                    tempNum++;
                }
            }else {
                if (set.contains(s.charAt(i))){
                    tempNum++;
                }
                if (set.contains(s.charAt(i - k))){
                    tempNum--;
                }
            }
            res = Math.max(res, tempNum);
        }

        return res;
    }

    @Test
    public void test(){
        System.out.println(maxVowels("tryhard", 4));
    }
}
