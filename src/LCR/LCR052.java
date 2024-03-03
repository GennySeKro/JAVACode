package LCR;
import HOT.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LCR052 {
    /*
    递增顺序搜索树
     */

    List<Integer> res = new ArrayList<>();
    public TreeNode increasingBST(TreeNode root) {
        dfs(root);
       TreeNode head = new TreeNode();
       TreeNode cur = head;
       for (int value : res){
           cur.right = new TreeNode(value);
           cur = cur.right;
       }
       return head.right;
    }

    private void dfs(TreeNode root) {
        if (root == null){
            return;
        }
        dfs(root.left);
        res.add(root.val);
        dfs(root.right);
    }
}
