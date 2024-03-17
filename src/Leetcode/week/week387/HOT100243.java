package Leetcode.week.week387;

import java.util.ArrayList;
import java.util.List;

public class HOT100243 {
    /*
    将元素分配到两个数组中
     */

    public int[] resultArray(int[] nums) {
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        arr1.add(nums[0]);
        arr2.add(nums[1]);
        int arr1Last = nums[0];
        int arr2Lsat = nums[1];
        for (int i = 2;i < nums.length;i++){
            if (arr1Last > arr2Lsat){
                arr1.add(nums[i]);
                arr1Last = nums[i];
            }else {
                arr2.add(nums[i]);
                arr2Lsat = nums[i];
            }
        }
        for (int i = 0;i < arr2.size();i++){
            arr1.add(arr2.get(i));
        }
        int[] res = new int[arr1.size()];
        for (int i = 0;i < res.length;i++){
            res[i] = arr1.get(i);
        }
        return res;

    }
}
