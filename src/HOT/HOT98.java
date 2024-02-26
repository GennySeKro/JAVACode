package HOT;

import java.util.ArrayList;
import java.util.List;

public class HOT98 {

    /*
    验证二叉搜索树
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

    public boolean isValidBST(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        order(root,res);
        for(int i = 0;i < res.size();i++){
            if(res.get(i) >= res.get(i+1)){
                return false;
            }
        }
        return true;

    }

    private void order(TreeNode root, List res){
        if(root == null){
            return;
        }
        order(root.left,res);
        res.add(root.val);
        order(root.right,res);
    }
}
