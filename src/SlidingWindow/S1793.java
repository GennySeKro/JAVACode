package SlidingWindow;

public class S1793 {
    /*
    好子数组的最大分数
     */

    public int maximumScore(int[] nums, int k) {
        int res = nums[k], tempMinValue = nums[k];
        int left = k, right = k;
        for (int i = 0;i < nums.length - 1;i++){
            if (right == nums.length - 1 || left > 0 && nums[left - 1] > nums[right + 1]){
                tempMinValue= Math.min(tempMinValue, nums[--left]);
            }else {
                tempMinValue = Math.min(tempMinValue, nums[++right]);
            }
            res = Math.max(res, tempMinValue * (right - left + 1));
        }
        return res;
    }
}
