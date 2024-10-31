package Tree;

import UItilsClass.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T971 {
    /*
    翻转二叉树以匹配先序遍历
     */

    int i = 0;
    List<Integer> res = new ArrayList<>();
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        if (dfs(root, voyage)) {
            return res;
        }
        return Arrays.asList(-1);
    }

    boolean dfs(TreeNode root, int[] v) {
        if (root == null) return true;
        if (root.val != v[i++]) return false;
        if (root.left != null && root.left.val != v[i]) {
            res.add(root.val);
            return dfs(root.right, v) && dfs(root.left, v);
        }
        return dfs(root.left, v) &&dfs(root.right, v);
    }
}
