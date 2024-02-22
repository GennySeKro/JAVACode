import org.junit.Test;

public class HOT80 {
    /*
    删除有序数组中的重复项Ⅱ
     */

    public int removeDuplicates(int[] nums) {
        int num = 1, k = nums[0], mov = 0, len = 1;
        for (int i = 1;i < nums.length;i++){
            if (nums[i] == k){
                if (num == 2){
                    mov++;
                }else {
                    num++;
                    len++;
                    nums[i - mov] = nums[i];
                }
            }else {
                k = nums[i];
                num = 1;
                nums[i - mov] = nums[i];
                len++;
            }
        }
        return len;
    }

    @Test
    public void test(){
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3}));
    }
}
