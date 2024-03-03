package LCR;
import HOT.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LCR053 {
    /*
    二叉搜索树的中继后继
     */


    List<TreeNode> res = new ArrayList<>();
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        dfs(root);
       for (int i = 1;i < res.size();i++){
           if (res.get(i - 1) == p){
               return res.get(i);
           }
       }
       return null;
    }

    private void dfs(TreeNode root) {
        if (root == null){
            return;
        }
        dfs(root.left);
        res.add(root);
        dfs(root.right);
    }
}
