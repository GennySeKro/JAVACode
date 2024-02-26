package HOT;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class  HOT101 {
    /*
    对称二叉树
     */

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return cmp(root.left, root.right);
    }

    private boolean cmp(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null || node1.val != node2.val) {
            return false;
        }

        return cmp(node1.left, node2.right) && cmp(node1.right, node2.left);
    }

    @Test
    public void test(){

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(2);
        root.left.right = null;
        root.right.left = new TreeNode(2);
        root.right.right = null;

        isSymmetric(root);
    }
}
