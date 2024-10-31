package LinkedList;

import UItilsClass.ListNode;

import java.util.HashMap;
import java.util.Map;

public class L171 {
    /*
    从链表中删去总和值为零的连续节点
     */

    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode virtualNode = new ListNode(0, head);
        int preSum = 0;
        Map<Integer, ListNode> map = new HashMap<>();

        for (ListNode p = virtualNode;p != null;p = p.next){
            preSum += p.val;
            map.put(preSum, p);
        }

        preSum = 0;
        for (ListNode p = virtualNode;p != null;p = p.next){
            preSum += p.val;
            p.next = map.get(preSum).next;
        }

        return virtualNode.next;
    }
}
