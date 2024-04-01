package rating1500_1700;

public class G2425 {
    /*
    所有数对的异或和
     */

    public int xorAllNums(int[] nums1, int[] nums2) {
        int xor = 0;
        if (nums2.length % 2 != 0){
            for (int num : nums1){
                xor = xor ^ num;
            }
        }
        if (nums1.length % 2 != 0){
            for (int num : nums2){
                xor = xor ^ num;
            }
        }
        return xor;
    }
}
