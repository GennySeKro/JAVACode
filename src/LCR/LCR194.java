package LCR;
import HOT.TreeNode;

public class LCR194 {
    /*
    二叉树的最近公共祖先
     */

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return null;
        }
        if (p == root || q == root){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null){
            return right;
        }
        if (right == null){
            return left;
        }
        return root;
    }
}
