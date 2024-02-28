package LCR;
import HOT.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class LCR056 {
    /*
    两数之和Ⅳ-输入二叉搜索树
     */

    private Set<Integer> set;
    public boolean findTarget(TreeNode root, int k) {
        set = new HashSet<>();
        return dfs(root, k);
    }

    private boolean dfs(TreeNode root, int k) {
        if (root == null){
            return false;
        }
        if (set.contains(k - root.val)){
            return true;
        }else {
            set.add(root.val);
            return dfs(root.left, k) || dfs(root.right, k);
        }
    }
}
