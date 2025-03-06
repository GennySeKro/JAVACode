package Leetcode.week.week439;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Q1 {
    /*
    找出最大的几近缺失整数
     */

    public int largestInteger(int[] nums, int k) {
        int res = -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        if (nums.length == k){
            for (int num : nums){
                res = Math.max(res, num);
            }
            return res;
        }
        if (k == 1){
            for (int num : nums){
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()){
                if (entry.getValue() == 1){
                    res = Math.max(res, entry.getKey());
                }
            }
            return res;
        }
        int left = nums[0], right = nums[nums.length - 1];
        int count = 0;

        for (int num : nums){
            if (num == left){
                count++;
            }
        }
        if (count == 1){
            res = left;
        }

        count = 0;
        for (int num : nums){
            if (num == right){
                count++;
            }
        }

        if (count == 1){
            res = Math.max(res, right);
        }

        return res;
    }

}
