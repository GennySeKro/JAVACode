import java.util.Arrays;

public class HOT238 {
    /*
    除自身以外数组的乘积
    时间复杂度O(n)，空间复杂度O(n)
     */

    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        left[0] = nums[0];
        right[nums.length - 1] = nums[nums.length - 1];
        for(int i = 1;i < nums.length;i++){
            left[i] = left[i - 1] * nums[i];
            right[nums.length - i - 1] = right[nums.length - i] * nums[nums.length - i -1];
        }

        int[] ans = new int[nums.length];
        ans[0] = right[1];
        ans[nums.length - 1] = left[nums.length-2];
        for(int i = 1;i < nums.length - 1;i++){
            ans[i] = left[i-1] * right[i + 1];
        }

        return ans;
    }

    /*
    优化:时间复杂度O(n),空间复杂度O(1)
     */
    public int[] productExceptSelf1(int[] nums){
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans,1);

        int beforeSum = 1;
        int afterSum = 1;
        for(int i = 0,j = n-1;i < n;i++,j--){
            ans[i] = ans[i] * beforeSum;
            ans[j] = ans[j] * afterSum;
            beforeSum = beforeSum * nums[i];
            afterSum = afterSum * nums[j];
        }

        return ans;
    }
}
