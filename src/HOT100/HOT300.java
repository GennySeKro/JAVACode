package HOT100;

/**
 * @author 抹茶味的榴莲蛋糕
 */
public class HOT300 {
    /*
    最长递增子序列
     */

    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;
        for (int num : nums){
            int i = 0, j = res;
            while (i < j){
                int m = (i + j) / 2;
                if (tails[m] < num){
                    i = m + 1;
                }else {
                    j = m;
                }
            }
            tails[i] = num;
            if (res == j){
                res++;
            }
        }
        return res;
    }
}
