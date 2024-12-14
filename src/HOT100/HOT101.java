package HOT100;

import UItilsClass.TreeNode;

public class HOT101 {
    /*
    对称二叉树
     */

    public boolean isSymmetric(TreeNode root) {
        if (root == null || root.left == null && root.right == null){
            return true;
        }

        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null){
            return true;
        }
        if (left == null || right == null || left.val != right.val){
            return false;
        }

        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
