package HOT;

import java.util.Arrays;

public class HOT16 {
    /*
    最接近的三数之和
     */

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0, near = Integer.MAX_VALUE;
        for(int i = 0;i < nums.length;i++){
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            for (int j = i + 1, k = nums.length - 1;j < k;){
                int sum = nums[i] + nums[j] + nums[k];
                if (near > Math.abs(sum - target)){
                    near = Math.abs(sum - target);
                    res = sum;
                }
                if (sum > target){
                    k--;
                }else if (sum < target){
                    j++;
                }else {
                    return target;
                }
            }
        }
        return res;

    }
}
