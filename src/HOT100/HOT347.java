package HOT100;

import java.util.*;

public class HOT347 {
    /*
    前K个高频元素
     */

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for(int num : nums){
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        List<int[]> numCnt = new ArrayList<int[]>();
        for(Map.Entry<Integer, Integer> entry : count.entrySet()){
            int num = entry.getKey(), cnt = entry.getValue();
            numCnt.add(new int[]{num, cnt});
        }
        List<int[]> topKs = findTopK(numCnt, k, 0, count.size() - 1);
        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = topKs.get(i)[0];
        }
        return res;
    }

    private List<int[]> findTopK(List<int[]> numCnt, int k, int low, int high){
        int pivot = low + (int)(Math.random()*(high - low + 1));
        Collections.swap(numCnt, low, pivot);
        int base = numCnt.get(low)[1];
        int i = low;
        for(int j = low + 1; j <= high; j++){
            if(numCnt.get(j)[1] > base){
                Collections.swap(numCnt, i + 1, j);
                i++;
            }
        }
        Collections.swap(numCnt, low, i);
        if(i == k - 1){
            return numCnt.subList(0, k);
        }else if(i > k - 1){
            return findTopK(numCnt, k, low, i - 1);
        }else{
            return findTopK(numCnt, k, i + 1, high);
        }
    }
}
