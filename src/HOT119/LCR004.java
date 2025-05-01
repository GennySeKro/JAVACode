package HOT119;

public class LCR004 {
    /*
    只出现一次的数字Ⅱ
     */

    public int singleNumber(int[] nums) {
        int a = 0, b = 0;
        for (int x : nums) {
            b = (b ^ x) & ~a;
            a = (a ^ x) & ~b;
        }
        return b;
    }
}
