package HOT;

import org.junit.Test;

public class HO100186 {
    /*
    匹配模式数组的子数组数目Ⅰ
     */

    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int res = 0;
        for (int i = 0;i < nums.length - pattern.length;i++){
            int k = 0;
            for (int j = 0;j < pattern.length;j++){
                if (pattern[j] == -1 && nums[i + j + 1] < nums[i + j]){
                    k++;
                } else if (pattern[j] == 0 && nums[i + j + 1] == nums[i + j]){
                    k++;
                } else if (pattern[j] == 1 && nums[i + j + 1] > nums[i + j]) {
                    k++;
                }else {
                    break;
                }
            }
            if (k == pattern.length){
                res++;
            }
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(countMatchingSubarrays(new int[]{1,2,3,4,5,6}, new int[]{1,1}));
    }
}
