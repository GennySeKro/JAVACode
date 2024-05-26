package Leetcode.week.week395;

import org.junit.Test;

import java.util.*;

public class HOT3132 {
    /*
    找出与数组相加的整数Ⅱ
     */

    public int minimumAddedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] resValue = new int[3];
        for (int i = 0;i < 3;i++){
            resValue[i] = nums2[0] - nums1[i];
        }
        Arrays.sort(resValue);
        for (int i = 0;i < resValue.length;i++){
            int num1 = 0, num2 = 0;
            int sum = 0;
            while (num1 < nums1.length && num2 < nums2.length){
                if (nums1[num1] + resValue[i] == nums2[num2]){
                    num1++;
                    num2++;
                }else {
                    if (sum > 2){
                        break;
                    }
                    sum++;
                    num1++;
                }
            }
            if (!(sum > 2)){
                return resValue[i];
            }
        }
        return -1;
    }


    @Test
    public void test(){
        System.out.println(minimumAddedInteger(new int[]{4,6,3,1,4,2,10,9,5}, new int[]{5,10,3,2,6,1,9}));
    }
}
