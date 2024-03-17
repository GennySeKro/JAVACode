package LCR;
import org.junit.Test;

import java.util.*;

public class LCR007 {
    /*
    三数之和
     */

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0;i < nums.length - 2;i++){
            if (i != 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int left = i + 1, right = nums.length - 1;
            while (left < right){
                if (nums[left] + nums[right] + nums[i] == 0){
                    int index = i;
                    int finalLeft = left;
                    int finalRight = right;
                    if (nums[left] == nums[left - 1] && left != i + 1){
                        left++;
                        continue;
                    }
                    if (right != nums.length - 1){
                        if (nums[right] == nums[right + 1]){
                            right--;
                            continue;
                        }
                    }
                    res.add(new ArrayList<>(){{
                        add(nums[finalLeft]);
                        add(nums[finalRight]);
                        add(nums[index]);
                    }});
                    left++;
                } else if (nums[left] + nums[right] + nums[i] > 0) {
                    right--;
                }else {
                    left++;
                }
            }
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(threeSum(new int[]{0,0,0,0}));
    }
}
