package Tree;

import UItilsClass.TreeNode;

public class T129 {
    /*

     */

    private int res = 0;

    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode root, int value) {
        if (root == null){
            return;
        }

        value = value * 10 + root.val;
        if (root.left == null && root.right == null){
            res += value;
            return;
        }

        dfs(root.left, value);
        dfs(root.right, value);
    }
}
