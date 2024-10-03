package SlidingWindow;

import org.junit.Test;

public class S1248 {
    /*
    统计优美子数组
     */

    public int numberOfSubarrays(int[] nums, int k) {
       int[] prefixCnt = new int[nums.length + 1];
       prefixCnt[0] = 1;
       int res = 0, sum = 0;
       for (int num : nums){
           sum += num & 1;
           prefixCnt[sum]++;
           if (sum >= k){
               res += prefixCnt[sum - k];
           }
       }

       return res;
    }

    @Test
    public void test(){
        System.out.println(numberOfSubarrays(new int[]{1,1,2,1,1}, 3));
    }
}
