import org.junit.Test;

public class HOT2 {
    /*
    两数相加
     */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }

    @Test
    public void test(){
        ListNode root1 = new ListNode(9);
        ListNode root2 = new ListNode(1);
        root2.next = new ListNode(9);
        root2.next.next = new ListNode(9);
        root2.next.next.next = new ListNode(9);
        root2.next.next.next.next = new ListNode(9);
        root2.next.next.next.next.next = new ListNode(9);
        root2.next.next.next.next.next.next = new ListNode(9);
        root2.next.next.next.next.next.next.next = new ListNode(9);
        root2.next.next.next.next.next.next.next.next = new ListNode(9);
        root2.next.next.next.next.next.next.next.next.next = new ListNode(9);
        addTwoNumbers(root1, root2);
    }
}
