package HOT100;

import UItilsClass.ListNode;

public class HOT148 {
    /*
    排序链表
     */

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode head2 = midNode(head);
        head = sortList(head);
        head2 = sortList(head2);

        return merge(head, head2);
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (list1 != null && list2 != null){
            if(list1.val < list2.val){
                cur.next = list1;
                list1 = list1.next;
            }else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        cur.next = list1 != null ? list1 : list2;
        return dummy.next;
    }

    private ListNode midNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        return mid;
    }
}
