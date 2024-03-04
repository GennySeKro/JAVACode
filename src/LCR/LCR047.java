package LCR;
import HOT.TreeNode;

public class LCR047 {
    /*
    二叉树剪枝
     */

    public TreeNode pruneTree(TreeNode root) {
        dfs(root);
        if (root.val == 0 && root.left == null && root.right == null){
            return null;
        }
        return root;
    }

    private boolean dfs(TreeNode root) {
        if (root == null){
            return false;
        }
        boolean left = dfs(root.left);
        if (!left){
            root.left = null;
        }
        boolean right = dfs(root.right);
        if (!right){
            root.right = null;
        }
        return root.val == 1 || left || right;
    }
}
