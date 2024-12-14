package HOT100;

import UItilsClass.TreeNode;

public class HOT543 {
    /*
    二叉树的直径
     */

    private int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null){
            return -1;
        }

        int leftLen = dfs(root.left) + 1;
        int rightLen = dfs(root.right) + 1;

        res = Math.max(res, leftLen + rightLen);
        return Math.max(leftLen, rightLen);
    }
}
