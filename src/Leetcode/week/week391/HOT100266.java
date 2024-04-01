package Leetcode.week.week391;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class HOT100266 {
    /*
    交替子数组计数
     */

    public long countAlternatingSubarrays(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        long res = 0;
        for (int i = 1;i < nums.length;i++){
           if (list.get(list.size() - 1) != nums[i]){
               list.add(nums[i]);
           }else {
               res = res + (long) (list.size() + 1) * list.size() / 2;
               list = new ArrayList<>();
               list.add(nums[i]);
           }
        }
        if (!list.isEmpty()){
            return res + (long) (list.size() + 1) * list.size() / 2;
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(countAlternatingSubarrays(new int[]{0,1,0,1}));
    }
}
