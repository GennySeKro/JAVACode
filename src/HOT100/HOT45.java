package HOT100;

public class HOT45 {
    /*
    跳跃游戏
     */

    public int jump(int[] nums) {
        int ans = 0;
        int curRight = 0; // 已建造的桥的右端点
        int nextRight = 0; // 下一座桥的右端点的最大值
        for (int i = 0; i < nums.length - 1; i++) {
            nextRight = Math.max(nextRight, i + nums[i]);
            if (i == curRight) { // 到达已建造的桥的右端点
                curRight = nextRight; // 造一座桥
                ans++;
            }
        }
        return ans;
    }
}
