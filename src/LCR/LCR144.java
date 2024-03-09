package LCR;
import HOT.TreeNode;

public class LCR144 {
    /*
    翻转二叉树
     */

    public TreeNode mirrorTree(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode root) {
        if (root == null){
            return;
        }
        TreeNode cur = root.left;
        root.left = root.right;
        root.right = cur;
        dfs(root.left);
        dfs(root.right);
    }
}
