package rating1500_1700;

import java.util.Arrays;

public class G2708 {
    /*
    一个小组的最大实力
     */

    public long maxStrength(int[] nums) {

        if(nums.length == 1) { return nums[0]; }

        Arrays.sort(nums);

        // 如果最大值与最小值都是0，那么说明整个数组都是0
        if(nums[0] == 0 && nums[nums.length-1] == 0) { return 0; }

        long res=1;
        boolean flag=false;

        for(int i=nums.length-1; i>=0; --i){
            // 先取正数
            if(nums[i] > 0){ res*=nums[i]; flag=true; }
            else if(nums[i] < 0){
                // 负数
                int j=i;  // 剩余的数量
                if((j&1) != 1) { --j; } // 奇数变偶数
                while(j >= 0){
                    res*=nums[j--];
                    flag=true;
                }
                break;
            }
        }
        // 排除数组除了一个数为负数，其余数为0的情况
        return flag ? res : 0;
    }
}
