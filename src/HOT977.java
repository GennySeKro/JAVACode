import java.util.Arrays;

public class HOT977 {
    /*
    有序数组的平方
     */

    /*
    平方+排序
    时间复杂度为 O(nlogn)
    空间复杂度为 O(1)
     */
    class one{
        public int[] sortedSquares(int[] nums) {
            for(int i = 0;i < nums.length;i++){
                nums[i] = nums[i] * nums[i];
            }
            Arrays.sort(nums);
            return nums;
        }
    }

    /*
    双指针
    时间复杂度为 O(n)
    空间复杂度为 O(n)
     */
    class two{
        public int[] sortedSquares(int[] nums) {
            int[] res = new int[nums.length];
            int left = 0, right = nums.length - 1;
            int i = nums.length - 1;
            while (left <= right) {
                if (nums[left] * nums[left] > nums[right] * nums[right]) {
                    res[i] = nums[left] * nums[left];
                    left++;
                } else {
                    res[i] = nums[right] * nums[right];
                    right--;
                }
                i--;
            }
            return res;
        }
    }
}
