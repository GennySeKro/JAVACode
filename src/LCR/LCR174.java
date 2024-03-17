package LCR;
import HOT.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LCR174 {
    /*
    寻找二叉搜索树中的目标节点
     */

    List<Integer> list = new ArrayList<>();
    public int findTargetNode(TreeNode root, int cnt) {
        dfs(root, cnt);
        return list.get(cnt - 1);
    }

    private void dfs(TreeNode root, int cnt) {
        if (list.size() == cnt){
            return;
        }
        if (root == null){
            return;
        }
        dfs(root.right, cnt);
        list.add(root.val);
        dfs(root.left, cnt);
    }
}
