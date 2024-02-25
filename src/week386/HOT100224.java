package week386;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class HOT100224 {
    /*
    分割数组
     */

    public boolean isPossibleToSplit(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0;i < nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.get(nums[i]) > 2){
                return false;
            }
        }
        return true;
    }

    @Test
    public void test(){
        System.out.println(isPossibleToSplit(new int[]{1,1,2,2,3,4}));
    }
}
