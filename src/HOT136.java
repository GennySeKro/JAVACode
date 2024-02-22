import java.util.HashMap;
import java.util.Map;

public class HOT136 {
    /*
    只出现一次的数字
     */

    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int res = 0;
        for(int i = 0;i < nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],2);
            }else {
                map.put(nums[i],1);
            }
        }
        for(int i = 0;i<nums.length;i++){
            if(map.get(nums[i]) == 1){
                res = nums[i];
                break;
            }
        }
        return res;
    }
}
