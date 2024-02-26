package HOT;

public class HOT203 {
    /*
    移除链表元素
     */

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeElements(ListNode head, int val) {
       ListNode root = new ListNode(-1,head);
       ListNode p = head;
       ListNode pre = root;
       while(p != null){
           if(p.val == val){
               pre.next = p.next;
           }else {
               pre = p;
           }
           p = p.next;
       }
       return root.next;
    }
}
