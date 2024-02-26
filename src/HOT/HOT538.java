package HOT;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class HOT538 {
    /*
    把二叉搜索树转换为累加树
     */

    public class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode convertBST(TreeNode root) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,0);
        dfs(root,map);
        return root;
    }

    private void dfs(TreeNode root, Map<Integer,Integer> map) {
        if(root == null){
            return;
        }
        dfs(root.right,map);
        root.val = map.get(0) + root.val;
        map.put(0,root.val);
        dfs(root.left,map);
    }

    @Test
    public void test(){
        TreeNode root = new TreeNode(4);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);
        convertBST(root);
    }
}
