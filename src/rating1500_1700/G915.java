package rating1500_1700;

import org.junit.Test;

import java.lang.annotation.Target;

public class G915 {
    /*
    分割数组
     */

    public int partitionDisjoint(int[] nums) {
        int[] leftMax = new int[nums.length];
        int[] rightMin = new int[nums.length];
        leftMax[0] = nums[0];
        rightMin[nums.length - 1] = nums[nums.length - 1];
        int max = nums[0], min = nums[nums.length - 1];
        for (int i = 0;i < nums.length;i++){
            if (nums[i] > max){
                max = nums[i];
            }
            leftMax[i] = max;
        }

        for (int i = nums.length - 1;i >= 0;i--){
            if (nums[i] < min){
                min = nums[i];
            }
            rightMin[i] = min;
        }
        for (int i = 1;i < nums.length;i++){
            if (leftMax[i - 1] <= rightMin[i]){
                return i;
            }
        }
        return 0;
    }

    @Test
    public void test(){
        System.out.println(partitionDisjoint(new int[]{5,0,3,8,6}));
    }

}
