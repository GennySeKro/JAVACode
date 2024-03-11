package LCR;

import java.util.PriorityQueue;

public class LCR159 {
    /*
    库存管理
     */

    public int[] inventoryManagement(int[] stock, int cnt) {
        if (cnt == 0){
            return new int[0];
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(cnt);
        for (int i = 0;i < stock.length;i++){
            queue.offer(stock[i]);
        }
        int[] res = new int[cnt];
        for (int i = 0;i < cnt;i++){
            res[i] = queue.poll();
        }
        return res;
    }
}
