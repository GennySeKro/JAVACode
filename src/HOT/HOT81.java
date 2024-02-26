package HOT;

public class HOT81 {
    /*
    搜索旋转排序数组Ⅱ
     */

    public boolean search(int[] nums, int target) {
        for (int i = 0;i < nums.length;i++){
            if (nums[i] == target){
                return true;
            }
        }
        return false;
    }
}
