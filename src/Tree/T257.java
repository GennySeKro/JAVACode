package Tree;

import UItilsClass.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class T257 {
    /*
    二叉树的所有路径
     */


    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> result = new ArrayList<>();
        if (root != null){
            dfs(root, "", result);
        }

        return result;
    }

    private void dfs(TreeNode root, String path, ArrayList<String> result) {
        if (root.left == null && root.right == null){
            result.add(path + root.val);
            return;
        }

        if (root.left != null){
            dfs(root.left, path + root.val + "->", result);
        }
        if (root.right != null){
            dfs(root.right, path + root.val + "->", result);
        }
    }
}
