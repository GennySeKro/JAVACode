import java.util.ArrayList;
import java.util.List;

public class HOT234 {
    /*
    回文链表
     */

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /*
    递归
     */
    class one{
        private ListNode p;
        public boolean isPalindrome(ListNode head) {
            p = head;
            return dfs(head);
        }

        private boolean dfs(ListNode head) {
            if(head != null){
                if(!dfs(head.next)){
                    return false;
                }
                if(head.val != p.val){
                    return false;
                }
                p = p.next;
            }
            return true;
        }
    }


    /*
    快慢指针+链表反转
     */
    class two{
        public boolean isPalindrome(ListNode head){
            if(head == null){
                return true;
            }

            ListNode firstHalfEnd = endOfFirstHalf(head);
            ListNode secondHalfStart = reverseList(firstHalfEnd.next);

            ListNode p1 = head;
            ListNode p2 = secondHalfStart;
            boolean res = true;
            while(res && p2 != null){
                if(p1.val != p2.val){
                    res = false;
                }
                p1 = p1.next;
                p2 = p2.next;
            }
            return res;
        }

        private ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode curr = head;
            while(curr != null){
                ListNode nextTemp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextTemp;
            }
            return prev;
        }

        private ListNode endOfFirstHalf(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            while(fast.next != null && fast.next.next != null){
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }
    }
}
