package LCR;
import org.junit.Test;

import java.util.*;

public class LCR061 {
    /*
    查找和最小的K对数字
     */

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // 创建一个小根堆，小根堆中存放 <nums1对应元素的索引，nums2对应元素的索引>
        ArrayList<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<int[]> heap = new PriorityQueue<>(
                (pair1, pair2) -> nums1[pair1[0]] + nums2[pair1[1]] - nums1[pair2[0]] - nums2[pair2[1]]
        );
        // 对小根堆进行初始化，将 <0,0>, ... , <k-1,0> 插入栈中（如果长度 n 小于 k 则取 n 个）。
        for(int i = 0; i < Math.min(k, nums1.length); i++){
            heap.add(new int[]{i,0});
        }

        for ( ; k > 0 && !heap.isEmpty(); k--){
            // 选出和最小的数对【i,j】(堆顶)，将堆顶弹出，把 `{nums1[i], nums2[j]}` 保存到列表中。
            int[] pair = heap.poll();
            ans.add(Arrays.asList(nums1[pair[0]],nums2[pair[1]]));
            // 当 `j + 1 < nums2.length` 时， 才将【i,j+1】插入堆中
            if(pair[1] < nums2.length - 1){
                heap.add(new int[]{pair[0], pair[1] + 1});
            }

        }
        // 返回结果
        return ans;
    }

    @Test
    public void test(){
        System.out.println(kSmallestPairs(new int[]{1,7,11}, new int[]{2,4,6}, 3));
    }
}
