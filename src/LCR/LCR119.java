package LCR;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class LCR119 {
    /*
    最长连续序列
     */

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums){
            set.add(num);
        }
        int res = 0;
        for (int num : set){
            if (!set.contains(num - 1)){
                int curNum = num;
                int len = 1;
                while (set.contains(curNum + 1)){
                    curNum = curNum + 1;
                    len = len + 1;
                }
                res = Math.max(res, len);
            }
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(longestConsecutive(new int[]{100,4,200,1,3,2}));
    }
}
