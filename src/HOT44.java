import java.util.ArrayList;
import java.util.List;

public class HOT44 {
    /*
    二叉树的前序遍历
     */

    public class TreeNode {
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

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(res,root);
        return res;
    }

    private void dfs(List<Integer> res, TreeNode root) {
        if(root == null){
            return;
        }else {
            res.add(root.val);
        }
        dfs(res,root.left);
        dfs(res,root.right);
    }
}
