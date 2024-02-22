import org.junit.Test;

public class HOT27 {
    /*
    移除元素
     */

    public int removeElement(int[] nums, int val) {
        int k = 0;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] == val){
                k++;
                continue;
            }
            nums[i-k] = nums[i];
        }
        return nums.length - k;
    }

    @Test
    public void test(){
        System.out.println(removeElement(new int[]{0,1,2,2,3,0,4,2},2));
    }
}
