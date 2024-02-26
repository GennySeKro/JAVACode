package HOT;

import java.util.ArrayList;
import java.util.List;

public class HOT94 {
    /*
    二叉树的中序遍历
     */

    public class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;
        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            inorder(root, res);
            return res;
        }

        private void inorder(TreeNode root, List<Integer> res) {
           if(root == null){
               return;
           }
           inorder(root.left,res);
           res.add(root.val);
           inorder(root.right,res);
        }
    }
}
