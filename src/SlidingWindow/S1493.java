package SlidingWindow;

import org.junit.Test;

public class S1493 {
    /*
    删掉一个元素以后全为1的最长子数组
     */

    public int longestSubarray(int[] nums) {
        // left不动，right右移，记录窗口内有多少个1
        // 当窗口内有两个0元素，把left指针跳到第一个0元素的下一个元素，减少1的数量
        boolean haveZero = false;
        int oneCount = 0, maxOneCount = 0, zeroIndex = 0;
        for (int left = 0, right = 0; right < nums.length; right++) {
            if (nums[right] == 1)
                // 遇到1
                oneCount++;
            else if (nums[right] == 0 && haveZero == false) {
                // 第一次遇到0，记录0的位置
                zeroIndex = right;
                haveZero = true;
            } else {
                // 多次遇到0，记录0的位置，把窗口左边界移动到0的下一个元素，减去舍弃区间中1的数量
                oneCount = oneCount - (zeroIndex - left);
                left = zeroIndex + 1;
                zeroIndex = right;
            }
            maxOneCount = Math.max(maxOneCount, oneCount);
        }
        // 考虑数组全1的情况
        return haveZero == false? maxOneCount - 1: maxOneCount;
    }

    @Test
    public void test(){
        System.out.println(longestSubarray(new int[]{1,1,0,0,1,1,1,0,1}));
    }
}
