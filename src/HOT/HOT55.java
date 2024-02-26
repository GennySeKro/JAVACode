package HOT;

import org.junit.Test;

public class HOT55 {
    /*
    跳跃游戏
     */


    /*
    贪心算法
    时间复杂度O(N)
    空间复杂度O(1)
     */
    class one{
        public boolean canJump(int[] nums){
            if (nums.length == 1) {
                return true;
            }
            //覆盖范围, 初始覆盖范围应该是0，因为下面的迭代是从下标0开始的
            int coverRange = 0;
            //在覆盖范围内更新最大的覆盖范围
            for (int i = 0; i <= coverRange; i++) {
                coverRange = Math.max(coverRange, i + nums[i]);
                if (coverRange >= nums.length - 1) {
                    return true;
                }
            }
            return false;
        }
    }

    /*
    暴力
    时间复杂度O(N*N)
    空间复杂度O(1)
     */
    class two{
        public boolean canJump(int[] nums) {
            if(nums.length == 1){
                return true;
            }
            for(int i = nums.length - 2;i >= 0;i--){
                if(nums[i] >= nums.length - 1 - i){
                    nums[i] = -1;
                }else {
                    for(int j = i+1;j < i + 1 + nums[i];j++){
                        if(nums[j] == -1){
                            nums[i] = -1;
                        }
                    }
                }
            }

            return nums[0] == -1 ? true : false;
        }
    }

    @Test
    public void test(){
        System.out.println(new two().canJump(new int[]{1, 1, 1, 0}));
    }

}
