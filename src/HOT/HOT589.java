package HOT;

import java.util.ArrayList;
import java.util.List;

public class HOT589 {
    /*
    N叉树的前序遍历
     */

    List<Integer> res;
    public List<Integer> preorder(Node root) {
        res = new ArrayList<>();
        dfs(root);
        return res;
    }

    private void dfs(Node root) {
        if (root == null){
            return;
        }
        res.add(root.val);
        for (int i = 0;i < root.children.size();i++){
            dfs(root.children.get(i));
        }
    }
}
