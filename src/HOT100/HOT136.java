package HOT100;

public class HOT136 {
    /*
    只出现一次的数字
     */

    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}
