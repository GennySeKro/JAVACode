package LCR;

import org.junit.Test;

public class LCR068 {
    /*
    搜索插入位置
     */

    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    @Test
    public void test(){
        System.out.println(searchInsert(new int[]{1,3,5,6}, 5));
    }
}
