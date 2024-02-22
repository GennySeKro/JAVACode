import org.junit.Test;

public class HOT560 {
    /*
    和为K的子数组
     */

    /*
    枚举
    时间复杂度O(N*N)
    空间复杂度O(1)
     */
    class one{
        public int subarraySum(int[] nums, int k) {
            int num = 0;
            for(int i = 0;i < nums.length;i++){

                if(nums[i] == k){
                    num++;
                }
                if(i == nums.length - 1){
                    break;
                }
                int sum = nums[i];
                for(int j = i + 1;j < nums.length;j++){
                    sum = sum + nums[j];
                    if(sum == k){
                        num++;
                    }
                }
            }
            return num;
        }
    }

    @Test
    public void test(){
        int[] arr = new int[]{1,-1,0};
        System.out.println(new one().subarraySum(arr,0));
    }

}
