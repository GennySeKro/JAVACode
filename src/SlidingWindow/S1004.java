package SlidingWindow;

public class S1004 {
    /*
    最大连续1的个数Ⅲ
     */

    public int longestOnes(int[] nums, int k) {
        int res = 0, zeroNum = 0;
        int right = 0, left = 0;

        while (right < nums.length){
            if (nums[right] == 0){
                zeroNum++;
                if (zeroNum > k){
                    res = Math.max(res, right - left);
                    while (zeroNum > k){
                        if (nums[left] == 0){
                            zeroNum--;
                        }
                        left++;
                    }
                }
            }
            right++;
        }
        res = Math.max(res, right - left);
        return res;
    }
}
