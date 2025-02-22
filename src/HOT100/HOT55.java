package HOT100;

import org.junit.Test;

public class HOT55 {
    /*
    跳跃游戏
     */

    public boolean canJump(int[] nums) {
        int mx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > mx) { // 无法到达 i
                return false;
            }
            mx = Math.max(mx, i + nums[i]); // 从 i 最右可以跳到 i + nums[i]
        }
        return true;
    }

    @Test
    public void test(){
        System.out.println(canJump(new int[]{0}));
    }
}
