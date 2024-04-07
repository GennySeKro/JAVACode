package Leetcode.week.week393;

import org.junit.Test;

import java.util.*;

public class HOT100267 {
    /*
    单面值组合的第 K 小金额
     */

    public long findKthSmallest(int[] coins, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        Arrays.sort(coins);
        List<Integer> list = new ArrayList<>();
        for (int i = 0;i < coins.length - 1;i++){
            for (int j = i + 1;j < coins.length;j++){
                if (coins[j] % coins[i] == 0){
                    coins[j] = 0;
                }
            }
        }
        int[] num = coins.clone();
        for (int i = 0;i < k;i++){
            for (int j = 0;j < coins.length;j++){
                if (queue.isEmpty()){
                    queue.add(num[j]);
                    num[j] = num[j] + coins[j];
                }else {
                    if (queue.size() < k){
                        queue.add(num[j]);
                        num[j] = num[j] + coins[j];
                        continue;
                    }
                    if (num[j] < queue.peek()){
                        queue.poll();
                        queue.add(num[j]);
                        num[j] = num[j] + coins[j];
                    }
                }
            }
        }
        return queue.peek();
    }

    @Test
    public void test(){
        System.out.println(findKthSmallest(new int[]{5,2}, 7));
    }
}
