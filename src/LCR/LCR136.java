package LCR;

import HOT.ListNode;
public class LCR136 {
    /*
    删除链表的节点
     */

    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val){
            return head.next;
        }
        ListNode left = head;
        ListNode right = head.next;
        while (right != null){
            if (right.val == val){
                left.next = right.next;
                break;
            }else {
                left = left.next;
                right = right.next;
            }
        }
        return head;
    }
}
