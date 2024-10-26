package Leetcode.week.week396;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class HOT100275 {
    /*
    K周期字符串需要的最少操作次数
     */

    public int minimumOperationsToMakeKPeriodic(String word, int k) {
        Map<String, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0;i < word.length();i = i + k){
            String temp = word.substring(i, i + k);
            map.put(temp, map.getOrDefault(temp, 0) + 1);
            max = Math.max(max, map.get(temp));
        }
//        System.out.println(word.length() / k - max);
        return word.length() / k - max;
    }


    @Test
    public void test(){
        minimumOperationsToMakeKPeriodic("leetcoleet",2);
    }
}
