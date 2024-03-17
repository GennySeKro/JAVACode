package LCR;
import HOT.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class LCR153 {
    /*
    二叉树中和为目标值的路径
     */

    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathTarget(TreeNode root, int target) {
        backTrack(root, target);
        return res;
    }

    private void backTrack(TreeNode root, int target) {
        if (root == null){
            return;
        }
        if (root.left == null && root.right == null && target == root.val){
            path.add(root.val);
            res.add(new ArrayList<>(path));
            path.removeLast();
            return;
        }
        path.add(root.val);
        backTrack(root.left, target - root.val);
        backTrack(root.right, target - root.val);
        path.removeLast();
    }
}
