package DataStructure.SegmentTree;

import DataStructure.SegmentTree.SegmentTree;
import org.junit.Test;

public class TestSegmentTree {

    @Test
    public void test(){
        int[] nums = {1, 3, 5, 7, 9, 11};
        SegmentTree segTree = new SegmentTree(nums);

        System.out.println(segTree.queryRange(1, 3)); // 输出区间 [1, 3] 的和：3 + 5 + 7 = 15

        segTree.update(1, 10); // 将 nums[1] 更新为 10
        System.out.println(segTree.queryRange(1, 3)); // 输出区间 [1, 3] 的和：10 + 5 + 7 = 22
    }
}
