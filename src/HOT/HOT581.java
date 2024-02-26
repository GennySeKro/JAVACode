package HOT;

import org.junit.Test;

import java.util.Arrays;

public class HOT581 {
    /*
    最短无序连续子数组
     */

    /*
    先排+比较，记录第一个和最后一个不同元素的索引
    时间复杂度O(N*logN)
    空间复杂度O(N)
     */
    class one{
        public int findUnsortedSubarray(int[] nums) {
            if(nums.length == 1){
                return 0;
            }
            int[] copy = new int[nums.length];
            for(int i = 0;i < nums.length;i++){
                copy[i] = nums[i];
            }
            int minIndex = nums.length, maxIndex =0;
            Arrays.sort(copy);
            if(Arrays.equals(copy,nums)){
                return 0;
            }
            for(int i = 0;i < nums.length;i++){
                if(copy[i] != nums[i]){
                    minIndex = Math.min(minIndex,i);
                    maxIndex = Math.max(maxIndex,i);
                }
            }

            return maxIndex - minIndex + 1;
        }
    }

    /*
    一次遍历
    时间复杂度O(N)
    空间复杂度O(1)
     */
    class two{
        public int findUnsortedSubarray(int[] nums) {
            int n = nums.length;
            int maxn = Integer.MIN_VALUE, right = -1;
            int minn = Integer.MAX_VALUE, left = -1;
            for(int i = 0;i < n;i++){
                if(maxn > nums[i]){
                    right = i;
                }else {
                    maxn = nums[i];
                }
                if(minn < nums[n-i-1]){
                    left = n-i-1;
                }else {
                    minn = nums[n-i-1];
                }
            }
            return right == -1 ? 0 : right - left + 1;
        }
    }



    @Test
    public void test(){
        int[] nums = new int[]{1,3,2,7,5,6};
        new two().findUnsortedSubarray(nums);
    }
}
