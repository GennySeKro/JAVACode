package HOT;

import org.junit.Test;

public class HOT704 {
    /*
    二分查找
     */

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] == target){
                return mid;
            }else {
                if(nums[mid] > target){
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

    @Test
    public void test(){
        System.out.println(search(new int[]{-1,0,3,5,9,12}, 9));
    }
}
