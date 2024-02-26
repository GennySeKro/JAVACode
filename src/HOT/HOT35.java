package HOT;

import org.junit.Test;

public class HOT35 {
    /*
    搜索插入位置
     */

    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    @Test
    public void test(){
        System.out.println(searchInsert(new int[]{1,3}, 0));
    }
}
