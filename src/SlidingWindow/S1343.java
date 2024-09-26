package SlidingWindow;

import org.junit.Test;

public class S1343 {
    /*
    大小为 K 且平均值大于等于阈值的子数组数目
     */

    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int res = 0;
        int tempSum = 0;
        for (int i = 0;i < k;i++){
            tempSum += arr[i];
        }
        if (tempSum / k >= threshold){
            res++;
        }

        for (int i = k;i < arr.length;i++){

            tempSum = tempSum - arr[i - k] + arr[i];

            if (tempSum / k >= threshold){
                res++;
            }
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(numOfSubarrays(new int[]{2,2,2,2,5,5,5,8}, 3, 4));
    }
}
