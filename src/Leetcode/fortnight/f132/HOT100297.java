package Leetcode.fortnight.f132;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class HOT100297 {
    /*
    找到连续赢K场比赛的第一位玩家
     */

    public int findWinningPlayer(int[] skills, int k) {
        if (k >= skills.length){
            int maxValue = skills[0], maxIndex = 0;
            for (int i = 1;i < skills.length;i++){
                if (skills[i] > maxValue){
                    maxValue = skills[i];
                    maxIndex = i;
                }
            }
            return maxIndex;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0;i < skills.length;i++){
            queue.add(skills[i]);
        }

        int num = 0, resIndex = 0;
        int nowValue = queue.poll();
        while (num != k){
            if (nowValue > queue.peek()){
                int temp = queue.poll();
                queue.add(temp);
                num++;
            }else {
                queue.add(nowValue);
                nowValue = queue.poll();
                num = 1;
            }
        }
        for (int i = 0;i < skills.length;i++){
            if (skills[i] == nowValue){
                return i;
            }
        }
        return 0;
    }

    @Test
    public void test(){
        System.out.println(findWinningPlayer(new int[]{4,2,6,3,9}, 2));
    }
}
