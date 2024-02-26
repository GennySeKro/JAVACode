import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class HOT938 {
    /*
    二叉搜索树的范围和
     */

    int res = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        dfs(root, low, high);
        return res;
    }

    private void dfs(TreeNode root, int low, int high) {
        if (root == null){
            return;
        }
        dfs(root.left, low, high);
        if (root.val >= low && root.val <= high){
            res = res + root.val;
        }
        dfs(root.right, low, high);
    }
}
