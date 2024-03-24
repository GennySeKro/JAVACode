package rating1500_1700;
import HOT.ListNode;
import HOT.TreeNode;

public class G1367 {
    /*
    二叉树中的链表
     */

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null){
            return true;
        }
        if (root == null){
            return false;
        }
        return isSub(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean isSub(ListNode head, TreeNode root) {
        if (head == null){
            return true;
        }
        if (root == null){
            return false;
        }
        if (head.val != root.val){
            return false;
        }
        return isSub(head.next, root.left) || isSub(head.next, root.right);
    }
}
