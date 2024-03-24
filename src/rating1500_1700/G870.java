package rating1500_1700;

import java.util.*;

public class G870 {
    /*
    洗牌优势
     */

    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        //nums1 从小到大排序
        Arrays.sort(nums1);
        // nums2 从大到小排序(带上索引)
        PriorityQueue<int[]> n2Sorted = new PriorityQueue<>(
                (a, b) -> {
                    return b[1] - a[1];
                }
        );
        for(int i = 0; i < nums2.length; i++){
            n2Sorted.offer(new int[]{i, nums2[i]});
        }
        int[] res = new int[n];
        // 左右指针记录nums1中没被排列过的元素
        int left = 0;
        int right = n-1;
        while(!n2Sorted.isEmpty()){
            int[] n2 = n2Sorted.poll();
            if(nums1[right] > n2[1]){
                res[n2[0]] = nums1[right--];
            }else{
                res[n2[0]] = nums1[left++];
            }
        }
        return res;
    }
}
