package LCR;
import HOT.ListNode;

public class LCR027 {
    /*
    回文链表
     */

    ListNode left;
    boolean res = true;
    public boolean isPalindrome(ListNode head) {
        left = head;
        ListNode right = head;
        dfs(right);
        return res;
    }

    private void dfs(ListNode right) {
        if (right == null){
            return;
        }
        dfs(right.next);
        if (res == false){
            return;
        }
        if (right.val != left.val){
            res = false;
            return;
        }
        left = left.next;
    }
}
