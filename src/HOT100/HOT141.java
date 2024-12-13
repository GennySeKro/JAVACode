package HOT100;

import UItilsClass.ListNode;

public class HOT141 {
    /*
    环形链表
     */

    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head; // 乌龟和兔子同时从起点出发
        while (fast != null && fast.next != null) {
            slow = slow.next; // 乌龟走一步
            fast = fast.next.next; // 兔子走两步
            if (fast == slow) // 兔子追上乌龟（套圈），说明有环
                return true;
        }
        return false; // 访问到了链表末尾，无环
    }
}
