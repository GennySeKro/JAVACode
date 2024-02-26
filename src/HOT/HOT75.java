package HOT;

import org.junit.Test;

public class HOT75 {
    /*
    颜色分类
     */

    @Test
    public void sortColors(int[] nums){
        int zero = 0;
        int one = 0;
        int two = 0;
        for (int num : nums) {
            switch (num) {
                case 0:
                    zero++;break;
                case 1:
                    one++;break;
                case 2:
                    two++;break;
            }
        }
        for(int i = 0;i < nums.length;i++){
            if(i < zero){
                nums[i] = 0;
            }else if (i < (zero+one)){
                nums[i] = 1;
            } else if (i < (zero+one+two)) {
                nums[i] = 2;
            }
        }
    }

    /*
    在第一次遍历中，我们将数组中所有的 000 交换到数组的头部。在第二次遍历中，
    我们将数组中所有的 111 交换到头部的 000 之后。此时，所有的 222 都出现在数组的尾部，这样我们就完成了排序
     */

    public void sortColors1(int[] nums){
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
        for(int i = ptr;i < n;i++){
            if(nums[i] == 1){
                temp = nums[ptr];
                nums[ptr] = 1;
                nums[i] = temp;
                ptr++;
            }
        }

    }
}
