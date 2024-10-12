package SlidingWindow;

import org.junit.Test;

public class S80 {
    /*
    删除有序数组中的重复项Ⅱ
     */

    public int removeDuplicates(int[] nums) {
        int count = 0;
        for (int num : nums){
            if (count < 2 || nums[count - 2] != num){
                nums[count++] = num;
            }
        }
        return count;
    }

    @Test
    public void test(){
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3}));
    }
}
