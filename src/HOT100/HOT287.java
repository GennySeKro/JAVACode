package HOT100;

public class HOT287 {
    /*
    寻找重复数
     */

    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        while (true) {
            // fast 前进两次，slow 前进一次
            fast = nums[fast];
            fast = nums[fast];
            slow = nums[slow];
            if (slow == fast) break;
        }

        // ptr == slow 时说明检测到重复元素，两个重复元素同时指向环的入口。
        int ptr = 0;
        while (ptr != slow) {
            ptr = nums[ptr];
            slow = nums[slow];
        }

        return ptr;
    }

}
