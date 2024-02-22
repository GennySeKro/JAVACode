import org.junit.Test;

import java.util.Arrays;

public class HOT45 {
    /*
    跳跃游戏Ⅱ
     */

    /*
    动态规划
    时间复杂度O(N*N)
    空间复杂度O(N)
     */
    class one{
        public int jump(int[] nums) {
            if(nums.length == 1){
                return 0;
            }
            //dp[i]表示到达nums[i]需要的最小步数
            int[] dp = new int[nums.length];
            Arrays.fill(dp,Integer.MAX_VALUE);
            dp[0] = 0;
            for(int i = 0;i < nums.length-1;i++){
                for(int j = i+1;j < i + 1 + nums[i];j++){
                    if(j <= nums.length-1){
                        dp[j] = Math.min(dp[j],dp[i] + 1);
                    }else {
                        break;
                    }

                }
            }
            return dp[nums.length-1];
        }
    }

    /*
    贪心算法
    时间复杂度O()
    空间复杂度O()
     */
    class two{
        public int jump(int[] nums) {
            if(nums == null || nums.length == 0 || nums.length == 1){
                return 0;
            }
            int count = 0;
            int curDistance = 0;
            int maxDistance = 0;
            for(int i = 0;i < nums.length;i++){
                maxDistance = Math.max(maxDistance,nums[i]+i);
                if(maxDistance >= nums.length-1){
                    count++;
                    break;
                }
                if(i == curDistance){
                    curDistance = maxDistance;
                    count++;
                }
            }
            return count;
        }
    }

    @Test
    public void test(){
        System.out.println(new two().jump(new int[]{2, 1}));
    }

}
