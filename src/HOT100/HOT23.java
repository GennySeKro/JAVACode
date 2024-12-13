package HOT100;

import UItilsClass.ListNode;

public class HOT23 {
    /*
    合并K个升序链表
     */

    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKLists(lists, 0, lists.length);
    }

    private ListNode mergeKLists(ListNode[] lists, int start, int end) {
        int num = end - start;
        if (num == 0){
            return null;
        }

        if (num == 1){
            return lists[start];
        }

        ListNode left = mergeKLists(lists, start, start + num / 2);
        ListNode right = mergeKLists(lists, start + num / 2, end);

        return mergeSortList(left, right);
    }


    private ListNode mergeSortList(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode();
        ListNode cur = dummy;

        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        cur.next = l1 == null ? l2 : l1;

        return dummy.next;
    }
}
