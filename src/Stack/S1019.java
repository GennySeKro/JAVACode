package Stack;

import UItilsClass.ListNode;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class S1019 {
    /*
    链表中的下一个更大节点
     */

    public int[] nextLargerNodes(ListNode head) {
        ArrayDeque<int[]> stack = new ArrayDeque<>();

        int len = 0;
        ListNode p = head;
        while (p != null){
            len++;
            p = p.next;
        }
        int[] res = new int[len];

        p = head;
        for (int i = 0;i < len;i++){
            while (!stack.isEmpty() && p.val > stack.peek()[1]){
                int[] value = stack.poll();
                res[value[0]] = p.val;
            }
            stack.push(new int[]{i, p.val});
            p = p.next;
        }
        while (!stack.isEmpty()){
            int[] value = stack.poll();
            res[value[0]] = 0;
        }
        return res;

    }
}
