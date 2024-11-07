package DP;

public class D2321 {
    /*
    拼接数组的最大分数
     */

    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        return Math.max(solve(nums1, nums2), solve(nums2, nums1));
    }

    private int solve(int[] nums1, int[] nums2) {
        int s1 = 0, maxSum = 0;
        for (int i = 1, s = 0;i < nums1.length;i++){
            s1 += nums1[i];
            s = Math.max(s + nums2[i] - nums1[i], 0);
            maxSum = Math.max(maxSum, s);
        }

        return s1 + maxSum;
    }


}
