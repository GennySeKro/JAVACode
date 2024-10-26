package Binary;

import org.junit.Test;

public class B34 {
    /*
    在排序数组中查找元素的第一个和最后一个位置
     */

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 1) {
            if (target == nums[0]){
                return new int[]{0,0};
            }else {
                return new int[]{-1,-1};
            }
        }
        boolean flag = false;
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int mid = (left + right) >> 1;
            if (nums[mid] == target){
                left = mid;
                while (left > 0 && nums[left - 1] == target){
                    left--;
                }
                right = mid;
                while (right < nums.length - 1 && nums[right + 1] == target){
                    right++;
                }
                flag = true;
                break;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }

        return flag ? new int[]{left, right} : new int[]{-1,-1};
    }


    @Test
    public void test(){
        System.out.println(searchRange(new int[]{1,3}, 3));
    }
}
