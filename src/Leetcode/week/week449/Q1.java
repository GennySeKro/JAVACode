package Leetcode.week.week449;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Q1 {
    /*
    不同字符数量最多为k时的最少删除数
     */

    public int minDeletion(String s, int k) {
        int[] characterNumArray = new int[26];
        int characterType = 0;
        int res = 0;
        for (char c : s.toCharArray()){
            if (characterNumArray[c - 'a'] == 0){
                characterType++;
            }
            characterNumArray[c - 'a']++;
        }

        while (characterType > k){
            int index = 0, min = Integer.MAX_VALUE;
            for (int i = 0; i < characterNumArray.length; i++){
                if (characterNumArray[i] != 0 && min > characterNumArray[i]){
                    min = characterNumArray[i];
                    index = i;
                }
            }
            res += characterNumArray[index];
            characterNumArray[index] = 0;
            characterType--;
        }

        return res;
    }

    @Test
    public void test(){
        System.out.println(minDeletion("yyyzz", 1));
    }
}
