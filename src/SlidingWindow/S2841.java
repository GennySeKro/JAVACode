package SlidingWindow;
import org.junit.Test;

import java.util.*;

public class S2841 {
    /*
    几乎唯一最大子数组的最大和
     */

    public long maxSum(List<Integer> nums, int m, int k) {
        long windowSum = 0L, res = 0L;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0;i < nums.size();i++){
            if (i < k){
                windowSum += nums.get(i);
                map.put(nums.get(i), map.getOrDefault(nums.get(i), 0) + 1);
                if (i == k - 1 && map.size() >= m){
                    res = Math.max(res, windowSum);
                }
            }else {
                map.put(nums.get(i), map.getOrDefault(nums.get(i), 0) + 1);
                if (map.get(nums.get(i - k)) == 1){
                    map.remove(nums.get(i - k));
                }else {
                    map.put(nums.get(i - k), map.get(nums.get(i - k)) - 1);
                }
                windowSum = windowSum - nums.get(i - k) + nums.get(i);
                if (map.size() >= m){
                    res = Math.max(res, windowSum);
                }
            }
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(maxSum(Arrays.asList(1,1,1,2), 2, 4));
    }
}
