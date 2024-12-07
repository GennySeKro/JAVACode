package HOT100;

public class HOT189 {
    /*
    轮转数组
     */

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (nums.length != 1){
            reverse(nums, 0, nums.length - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, nums.length - 1);
        }

    }

    private void reverse(int[] nums, int start, int end) {
        int tempValue = 0;
        while (start < end){
            tempValue = nums[start];
            nums[start] = nums[end];
            nums[end] = tempValue;
            start++;
            end--;
        }
    }
}
