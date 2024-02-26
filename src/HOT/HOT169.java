package HOT;

public class HOT169 {
    /*
    多数元素
     */

    public int majorityElement(int[] nums) {
        int res = 1;
        int max = nums[0];
        for(int i = 1;i < nums.length;i++){
            if(res == 0){
                max = nums[i];
                res = 1;
            } else if (max != nums[i]) {
                res--;
            }else {
                res++;
            }
        }
        return max;
    }
}
