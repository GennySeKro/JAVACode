package HOT100;

import UItilsClass.TreeNode;

public class HOT230 {
    /*
    二叉搜索树中第K小的元素
     */

    private int k;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        return dfs(root);
    }

    private int dfs(TreeNode root) {
        if (root == null){
            return -1;
        }

        int left = dfs(root.left);
        if (left != - 1){
            return left;
        }

        if (--k == 0){
            return root.val;
        }

        return dfs(root.right);
    }
}
