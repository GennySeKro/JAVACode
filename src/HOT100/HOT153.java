package HOT100;

import org.junit.Test;

public class HOT153 {
    /*
    寻找旋转排序数组中的最小值
     */

    public int findMin(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }

        int left = 0, right = nums.length - 1;
        int res = Math.min(nums[left], nums[right]);

        while (left <= right){
            int mid = (left + right) >> 1;

            if (nums[mid] >= nums[left]){
                res = Math.min(res, nums[left]);
                left = mid + 1;
            }else {
                res = Math.min(res, nums[mid]);
                right = mid - 1;
            }
        }

        return res;
    }


    @Test
    public void test(){
        System.out.println(findMin(new int[]{5,1,2,3,4}));
    }
}
