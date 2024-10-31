package LinkedList;

import UItilsClass.ListNode;

public class L206 {
    /*
    反转链表
     */

    /*
    递归
     */
    public ListNode reverseList0(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode newHead = reverseList0(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    /*
    迭代
     */
    public ListNode reverseList1(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
