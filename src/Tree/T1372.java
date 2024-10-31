package Tree;

import UItilsClass.TreeNode;

public class T1372 {
    /*
    二叉树中的最长交错路径
     */

    private int res = 0;

    public int longestZigZag(TreeNode root) {
        dfs(root, 0, true);
        return res;
    }

    private void dfs(TreeNode root, int len, boolean isLeft) {
        if (root == null){
            return;
        }

        res = Math.max(res, len);
        dfs(root.left, isLeft ? 1 : len + 1, true);
        dfs(root.right, isLeft ? len + 1 : 1, false);
    }
}
