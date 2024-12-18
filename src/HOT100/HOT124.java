package HOT100;

import UItilsClass.TreeNode;


public class HOT124 {
    /*
    二叉树中的最大路径和
     */

    private int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null){
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        res = Math.max(res, left + right + root.val);

        return Math.max(Math.max(left, right) + root.val, 0);
    }
}
