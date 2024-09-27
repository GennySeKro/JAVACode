package SlidingWindow;

import org.junit.Test;

public class S2134 {
    /*
    最少交换次数来组合所有的1
     */

    public int minSwaps(int[] nums) {
        int n=nums.length;
        int len=0;
        //统计数组中1的个数，结果作为滑动窗口的大小
        for (int i = 0; i < n; i++) {
            len+=nums[i];
        }
        //统计长度为len的窗口中1的个数
        int cnt=0;
        for (int i = 0; i < len; i++) {
            cnt+=nums[i];
        }

        //统计交换次数 统计每个窗口内1的数量 len（1的总数量）- cnt（窗口内1的数量）即要交换的次数
        //求最小值
        int time=len-cnt;
        for (int i = len; i < n+len-1; i++) {
            //i代表窗口的end位置 i-len代表窗口的start位置
            //考虑到环形 要使得i-len能遍历到n-1的位置 因此遍历长度往后扩展len-1
            //此外要对i进行取余操作防止越界
            cnt+=nums[i%n]-nums[i-len];
            time=Math.min(time,len-cnt);
        }
        return time;
    }

    @Test
    public void test(){
        System.out.println(minSwaps(new int[]{1,1,1,1,0,0,0,1,1}));
    }
}
