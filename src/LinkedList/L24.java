package LinkedList;

import UItilsClass.ListNode;
import org.junit.Test;

public class L24 {
    /*
    两两交换链表中的节点
     */

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode tempHead = new ListNode(-1, head);
        ListNode left = tempHead.next, right = tempHead.next.next;
        ListNode preLeft = tempHead;

        while (left != null && right != null){
            ListNode last = right.next;

            right.next = null;
            left.next = null;
            preLeft.next = right;
            right.next = left;
            left.next = last;
            if (left.next != null && left.next.next != null){
                left = left.next;
                right = left.next;
                preLeft = preLeft.next.next;
            }else {
                break;
            }
        }

        return tempHead.next;
    }

    @Test
    public void test(){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        System.out.println(swapPairs(head));
    }
}
