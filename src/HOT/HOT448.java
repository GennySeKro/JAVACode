package HOT;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HOT448 {
    /*
    找到所有数组中消失的数字
     */

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i < nums.length;i++){
            int num = Math.abs(nums[i]);
            if(nums[num - 1] > 0){
                nums[num - 1] = nums[num - 1] * -1;
            }
        }

        for(int i = 0;i < nums.length;i++){
            if(nums[i] > 0){
                list.add(i + 1);
            }
        }
        return list;
    }
}
