package monotoneStack;

import UItilsClass.ListNode;

import java.util.ArrayDeque;

public class mS1019 {
    /*
    链表中的下一个更大节点
     */

    public int[] nextLargerNodes(ListNode head) {
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        int n = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            n++;
        }

        int[] res = new int[n];
        int index = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            while (!stack.isEmpty() && stack.peek()[0] < cur.val) {
                res[stack.pop()[1]] = cur.val;
            }

            stack.push(new int[]{cur.val, index++});
        }

        return res;
    }
}
