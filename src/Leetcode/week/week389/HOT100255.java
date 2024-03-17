package Leetcode.week.week389;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HOT100255 {
    /*
    成为 K 特殊字符串需要删除的最少字符数
     */

    public int minimumDeletions(String word, int k) {
        int[]dict=new int[26];
        for(char c:word.toCharArray()){
            dict[c-'a']++;
        }
        Arrays.sort(dict);
        int res=word.length();
        int nDelete=0;
        for(int i=0;i<26;i++){
            int temp=0;
            for(int j=i+1;j<26;j++){
                if(dict[j]-dict[i]>k){
                    temp+=(dict[j]-dict[i]-k);
                }
            }
            res=Math.min(res,temp+nDelete);
            nDelete+=dict[i];
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(minimumDeletions("klllurlrrul", 1));
    }
}
