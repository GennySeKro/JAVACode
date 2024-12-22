package HOT100;

import org.junit.Test;

import java.util.Arrays;

public class HOT34 {
    /*
    在排序数组中查找元素的第一个和最后一个位置
     */

    public int[] searchRange(int[] nums, int target){
        if (nums.length == 0){
            return new int[]{-1, -1};
        }
        if (nums.length == 1){
            return nums[0] != target ? new int[]{-1, -1} : new int[]{0, 0};
        }

        int leftIndex = -1, rightIndex = -1;
        int left = 0, right = nums.length - 1;

        while (left <= right){
            int mid = (left + right) >> 1;

            if (nums[mid] == target){
                leftIndex = mid;
                rightIndex = mid;
                while (leftIndex - 1>= 0 && nums[leftIndex - 1] == target){
                    leftIndex--;
                }
                while (rightIndex + 1< nums.length && nums[rightIndex + 1] == target){
                    rightIndex++;
                }
                return new int[]{leftIndex, rightIndex};
            } else if (nums[mid] > target) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }

        return new int[]{leftIndex, rightIndex};
    }

    @Test
    public void test(){
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
    }
}
