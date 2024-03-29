package HOT;

import java.util.*;

public class HOT347 {
    /*
    前K个高频元素
     */

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> occurrences = new HashMap<>();
        for(int num : nums){
            occurrences.put(num,occurrences.getOrDefault(num,0) + 1);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] m, int[] n) {
                return m[1] - n[1];
            }
        });

        for(Map.Entry<Integer,Integer> entry : occurrences.entrySet()){
            int num = entry.getKey(), count = entry.getValue();
            if(queue.size() == k){
                if(queue.peek()[1] < count){
                    queue.poll();
                    queue.offer(new int[]{num,count});
                }
            }else {
                queue.offer(new int[]{num,count});
            }
        }
        int[] ret = new int[k];
        for(int i = 0;i < k;i++){
            ret[i] = queue.poll()[0];
        }
        return ret;
    }
}
