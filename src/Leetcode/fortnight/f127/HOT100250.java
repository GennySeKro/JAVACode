package Leetcode.fortnight.f127;

import org.junit.Test;

public class HOT100250 {
    /*
    得到更多分数的最少关卡数目
     */

    public int minimumLevels(int[] possible) {
        int[] preSum = new int[possible.length];
        int sum = possible[0] == 0 ? -1 : 1;
        preSum[0] = sum;
        for (int i = 1;i < possible.length - 1;i++){
            if (possible[i] == 0){
                sum = sum - 1;
            }else {
                sum = sum + 1;
            }
            preSum[i] = sum;
        }
        if (possible[preSum.length - 1] == 0){
            sum = sum - 1;
        }else {
            sum = sum + 1;
        }
        for (int i = 0;i < possible.length - 1;i++){
            if (preSum[i] > sum - preSum[i]){
                return i + 1;
            }
        }
        return -1;
    }

    @Test
    public void test(){
        System.out.println(minimumLevels(new int[]{1,1,1,1,1}));
    }
}
