package Tree;

import UItilsClass.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class T113 {
    /*
    路径总和Ⅱ
     */

    LinkedList<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        recur(root, targetSum);
        return res;
    }
    void recur(TreeNode root, int tar) {
        if (root == null) return;
        path.add(root.val);
        tar -= root.val;
        if (tar == 0 && root.left == null && root.right == null)
            res.add(new LinkedList<Integer>(path));
        recur(root.left, tar);
        recur(root.right, tar);
        path.removeLast();
    }
}
