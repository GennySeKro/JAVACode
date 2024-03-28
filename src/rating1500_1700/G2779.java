package rating1500_1700;

import java.util.Arrays;

public class G2779 {
    /*
    数组的最大美丽值
     */

    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 0;
        for (int left = 0, right = 0;right < nums.length;right++){
            while (nums[right] > nums[left] + 2 * k){
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
