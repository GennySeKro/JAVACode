package rating1500_1700;
import HOT.ListNode;

import java.util.*;

public class G1019 {
    /*
    链表中的下一个更大节点
     */

    public int[] nextLargerNodes(ListNode head) {
        List<Integer> num = new ArrayList<>();
        ListNode p = head;
        Stack<Integer> stack = new Stack<>();

        while (p != null) {
            num.add(p.val);
            p = p.next;
        }

        int[] res = new int[num.size()];
        for (int i = num.size() - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= num.get(i)) {
                stack.pop();
            }

            res[i] = stack.isEmpty() ? 0 : stack.peek();
            stack.push(num.get(i));
        }

        return res;
    }
}
