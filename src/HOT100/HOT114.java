package HOT100;

import UItilsClass.TreeNode;

public class HOT114 {
    /*
    二叉树展开为链表
     */

    public void flatten(TreeNode root) {
        dfs(root);
    }

    private TreeNode dfs(TreeNode root) {
        if (root == null){
            return null;
        }

        TreeNode leftTail = dfs(root.left);
        TreeNode rightTail = dfs(root.right);

        if (leftTail != null){
            leftTail.right = root.right;
            root.right = root.left;
            root.left = null;
        }

        return rightTail != null ? rightTail : leftTail != null ? leftTail : root;
    }
}
