import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HOT114 {
    /*
    二叉树展开为链表
    时间复杂度O(n),空间复杂度O(n)
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

    public void flatten(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        inorder(root,res);
        int size = res.size();
        for(int i = 1;i<size;i++){
            TreeNode prev = res.get(i-1);
            TreeNode curr = res.get(i);
            prev.left = null;
            prev.right = curr;
        }
    }
    private void inorder(TreeNode root, List<TreeNode> res) {
        if(root == null){
            return;
        }
        res.add(root);
        inorder(root.left,res);
        inorder(root.right,res);
    }

    /*
    优化：时间复杂度O(n),空间复杂度O(1)
     */
    public void flatten1(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode next = curr.left;
                TreeNode predecessor = next;
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                predecessor.right = curr.right;
                curr.left = null;
                curr.right = next;
            }
            curr = curr.right;
        }
    }

    @Test
    public void test(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);

        flatten(root);
    }

}
