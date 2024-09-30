package SlidingWindow;

import org.junit.Test;

public class S1650 {
    /*
    将x减到0的最小操作数
     */

    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for (int i = 0;i < nums.length;i++){
            sum += nums[i];
        }

        if (sum < x){
            return -1;
        }

        int temp = 0, res = Integer.MAX_VALUE;
        int right = 0, left = 0;
        while (right < nums.length){
            if (temp < sum - x){
                temp += nums[right];
                right++;
            }else if (temp == sum - x){
                res = Math.min(res, nums.length - (right - left));
                temp -= nums[left];
                left++;
            }else {
                while (temp > sum - x){
                    temp -= nums[left];
                    left++;
                }
            }
        }
        while (temp > sum - x){
            temp -= nums[left];
            left++;
            if (temp == sum - x){
                res = Math.min(res,  nums.length - (right - left));
                break;
            }
        }
        if (temp == sum - x){
            res = Math.min(res,  nums.length - (right - left));
        }

        return res == 0  ? -1 : res == Integer.MAX_VALUE ? -1 : res;
    }

    @Test
    public void test(){
        System.out.println(minOperations(new int[]{5,1,4,2,3}, 6));
    }
}
