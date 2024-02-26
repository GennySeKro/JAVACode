package HOT;

import java.util.*;

public class HOT18 {
    /*
    四数之和
     */

    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0;i < nums.length;i++){
            if(nums[i] > 0 && nums[i] > target){
                return result;
            }
            if(i > 0 && nums[i-1] == nums[i]){
                continue;
            }
            for(int j = i + 1;j < nums.length;j++){
                if(j > i + 1 && nums[j-1] == nums[j]){
                    continue;
                }

                int left = j + 1;
                int right = nums.length - 1;
                while(left < right){
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum > target){
                        right--;
                    } else if (sum < target) {
                        left++;
                    }else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while(right > left && nums[right] == nums[right-1]){
                            right--;
                        }
                        while (right > left && nums[left] == nums[left + 1]){
                            left++;
                        }
                        left++;
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
