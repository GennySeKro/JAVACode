package HOT;

import org.junit.Test;

public class HOT83 {
    /*
    删除排序链表中的重复元素
     */

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode left = head, right = head.next;
        while (right != null){
            if (left.val == right.val){
                if (right.next == null){
                    left.next = null;
                    break;
                }else {
                    right = right.next;
                    left.next = right;

                }
            }else {
                right = right.next;
                left = left.next;
            }
        }
        return head;
    }

    @Test
    public void test(){
        ListNode root = new ListNode(1);
        root.next = new ListNode(1);
        root.next.next = new ListNode(2);
        System.out.println(deleteDuplicates(root));
    }

}
