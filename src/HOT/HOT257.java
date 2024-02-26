package HOT;

import java.util.*;

public class HOT257 {
    /*
    二叉树的所有路径
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

    List<TreeNode> path = new ArrayList<>();
    List<String> res = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null){
            return;
        } else if (root.left == null && root.right == null) {
            StringBuilder s = new StringBuilder();
            for(int i = 0;i < path.size();i++){
                s.append(path.get(i).val);
                s.append(root.val);
            }
            s.append("->");
            res.add(s.toString());
            return;
        }else {
            path.add(root);
        }
        dfs(root.left);
        dfs(root.right);
        path.remove(path.size() - 1);
    }
}
