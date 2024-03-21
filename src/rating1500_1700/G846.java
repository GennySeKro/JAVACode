package rating1500_1700;

import org.junit.Test;

import java.util.*;

public class G846 {
    /*
    一手顺子
     */

    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b)->a-b);
        for (int i : hand) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            q.add(i);
        }
        while (!q.isEmpty()) {
            int t = q.poll();
            if (map.get(t) == 0) continue;
            for (int i = 0; i < groupSize; i++) {
                int cnt = map.getOrDefault(t + i, 0);
                if (cnt == 0) return false;
                map.put(t + i, cnt - 1);
            }
        }
        return true;
    }

    @Test
    public void test(){
        System.out.println(isNStraightHand(new int[]{1,2,3,6,2,3,4,7,8}, 3));
    }
}
