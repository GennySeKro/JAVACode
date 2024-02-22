import org.junit.Test;

public class HOT189 {

    /*
    轮转数组
     */

    public void rotate(int[] nums, int k) {
        if (nums.length != 1 && k != 0){
            if (k > nums.length){
                k = k % nums.length;
            }
            reverse(nums, 0, nums.length - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, nums.length - 1);
            return;
        }
    }

    private void reverse(int[] nums, int start, int end){
        int temp;
        for (int i = 0;i <= (end - start) / 2;i++){
            temp = nums[start + i];
            nums[start + i] = nums[end - i];
            nums[end - i] = temp;
        }
    }

    @Test
    public void test(){
        rotate(new  int[]{1,2}, 3);
    }
}
