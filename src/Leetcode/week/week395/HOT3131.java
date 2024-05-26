package Leetcode.week.week395;

import java.util.Arrays;

public class HOT3131 {
    /*
    找出与数组相加的整数Ⅰ
     */

    public int addedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        if (nums1[0] == nums2[0]){
            return 0;
        } else{
            return nums2[0] - nums1[0];
        }
    }
}
