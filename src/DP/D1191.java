package DP;

import org.junit.Test;

public class D1191 {
    /*
    K次串联后最大子数组之和
     */

    public int kConcatenationMaxSum(int[] arr, int k) {

        int n = arr.length;

        long minPreSum = 0;// 当前位置之前的最小前缀和
        long maxPreSum = 0;// 最大前缀和
        long preSum = 0;
        long maxSum = 0;// 最大子数组和

        for(int num : arr){
            preSum += num;
            maxSum = Math.max(maxSum, preSum - minPreSum);
            minPreSum = Math.min(minPreSum, preSum);
            maxPreSum = Math.max(maxPreSum, preSum);
        }

        long maxLastSum = 0;// 最大后缀和
        long lastSum = 0;

        for(int i = n - 1; i >= 0; i--){
            lastSum += arr[i];
            maxLastSum = Math.max(maxLastSum, lastSum);
        }

        long res = 0;

        // 单个数组中最大子数组
        res = Math.max(res, maxSum);

        // 两个数组各取最大后缀以及最大前缀
        if(k >= 2){
            res = Math.max(res, maxPreSum + maxLastSum);
        }

        // 首尾两个数组各取最大后缀以及最大前缀，中间全取
        if(k >= 2 && preSum > 0){
            res = Math.max(res, preSum * (k - 2) + maxPreSum + maxLastSum);
        }

        res %= 1000000007;

        return (int)res;
    }

    @Test
    public void test(){
        System.out.println(kConcatenationMaxSum(new int[]{1,-2,1}, 5));
    }
}
