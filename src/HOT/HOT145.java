package HOT;

import java.util.ArrayList;
import java.util.List;

public class HOT145 {
    /*
    二叉树的后序遍历
     */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(res, root);
        return res;
    }

    private void dfs(List<Integer> res, TreeNode root) {
        if(root == null){
            return;
        }else {
            dfs(res, root.left);
            dfs(res, root.right);
            res.add(root.val);
        }
    }
}
