package HOT;

import java.util.ArrayList;
import java.util.List;

public class HOT530 {
    /*
    二叉搜索树的最小绝对差
     */

    List<Integer> res = new ArrayList<>();
    public int getMinimumDifference(TreeNode root) {
        int min = Integer.MAX_VALUE;
        dfs(root);
        for(int i = 1;i < res.size();i++){
            min = Math.min(min,Math.abs(res.get(i) - res.get(i - 1)));
        }
        return min;
    }

    private void dfs(TreeNode root) {
        if (root == null){
            return;
        }
        dfs(root.left);
        res.add(root.val);
        dfs(root.right);
    }
}
