package HOT;

import java.util.*;

public class HOT590 {
    /*
    N叉树的后序遍历
     */

    List<Integer> res;
    public List<Integer> postorder(Node root) {
        res = new ArrayList<>();
        dfs(root);
        return res;
    }

    private void dfs(Node root) {
        if (root == null){
            return;
        }
        for (int i = 0;i < root.children.size();i++){
            dfs(root.children.get(i));
        }
        res.add(root.val);
    }
}
