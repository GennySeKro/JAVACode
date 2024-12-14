package HOT100;

import UItilsClass.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class HOT94 {
    /*
    二叉树的中序遍历
     */

    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        midorder(root, res);
        return res;
    }

    private void midorder(TreeNode root, ArrayList<Integer> res) {
        if (root == null){
            return;
        }

        midorder(root.left, res);
        res.add(root.val);
        midorder(root.right, res);
    }
}
