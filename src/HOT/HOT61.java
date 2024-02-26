package HOT;

import org.junit.Test;

public class HOT61 {
    /*
    旋转链表
     */

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0){
            return head;
        }
        ListNode p = head;
        int len = 0;
        while (p != null) {
            len++;
            p = p.next;
        }
        if (k != 1 && k % len == 0) {
            return head;
        } else if (len < k) {
            while (k > len) {
                k = k - len;
            }
        }
        ListNode fast = head;
        int num = 1;
        while (num < len - k) {
            fast = fast.next;
            num++;
        }
        ListNode sub = fast.next;
        fast.next = null;
        fast = sub;
        while (fast.next != null){
            fast = fast.next;
        }
        fast.next = head;
        return sub;
    }

    @Test
    public void test(){
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        rotateRight(root, 2);
    }
}
