package HOT100;

import UItilsClass.TreeNode;

public class HOT226 {
    /*
    翻转二叉树
     */

    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }

        TreeNode temp = new TreeNode();
        temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
