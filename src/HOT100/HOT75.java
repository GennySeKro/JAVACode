package HOT100;

import org.junit.Test;

public class HOT75 {
    /*
    颜色分类
     */

    public void sortColors(int[] nums) {
        int n = nums.length;
        int ptr = 0;
        int temp;
        for(int i = 0;i < n;i++){
            if(nums[i] == 0){
                temp = nums[ptr];
                nums[ptr] = 0;
                nums[i] = temp;
                ptr++;
            }
        }
        for(int i = ptr;i<n;i++){
            if(nums[i] == 1){
                temp = nums[ptr];
                nums[ptr] = 1;
                nums[i] = temp;
                ptr++;
            }
        }
    }

    @Test
    public void test(){
        sortColors(new int[]{2,0,2,1,1,0});
    }
}
