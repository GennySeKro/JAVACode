package HOT100;

public class HOT169 {
    /*
    多数元素
     */

    public int majorityElement(int[] nums) {
        int res = nums[0],  count= 1;
        for (int i = 1; i < nums.length; i++){
            if (count == 0){
                res = nums[i];
                count = 1;
            }else {
                if (nums[i] != res){
                    count--;
                }else {
                    count++;
                }
            }
        }

        return res;

    }
}
