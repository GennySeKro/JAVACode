public class HOT300 {
    /*
    最长递增子序列
    动态规划
    时间复杂度O(n*n),空间复杂度O(n)
     */

    public int lengthOfLIS(int[] nums) {
        int[] res = new int[nums.length];
        int max = 0;

        for(int i = 0;i < nums.length;i++){
            res[i] = findSmall(res,nums,i) + 1;
            max = Math.max(max,res[i]);
        }
        return max;
    }

    private int findSmall(int[] res, int[] nums, int value) {
        int max = 0;
        for(int i = 0;i < value;i++){
            if(nums[i] < nums[value]){
                max = Math.max(res[i], max);
            }
        }
        return max;
    }


    /*
    贪心+二分
    时间复杂度O(N*logN),空间复杂度O(N)
     */
    public int lengthOfLIS1(int[] nums){
        return 0;
    }

}
