public class HOT21 {
    /*
    合并两个有序链表
     */

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode root = new ListNode();
        ListNode start = root;
        ListNode p = list1;
        ListNode q = list2;
        ListNode k;
        while(p != null && q != null){
            if(p.val < q.val){
                k = p;
                p = p.next;
                root.next = k;
                k.next = null;
                root = root.next;
            }else {
                k = q;
                q = q.next;
                root.next  = k;
                k.next = null;
                root = root.next;
            }
        }
        if(p != null){
            while(p != null){
                k = p;
                p = p.next;
                root.next = k;
                k.next = null;
                root = root.next;
            }
        } else if (q != null) {
            while(q != null){
                k = q;
                q = q.next;
                root.next = k;
                k.next = null;
                root = root.next;
            }
        }
        return start.next;
    }
}
