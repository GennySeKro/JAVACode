package HOT;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class HOT106 {
    /*
    从中序与后续遍历序列构造二叉树
     */

    Map<Integer, Integer> map;

    public TreeNode buildTree(int[] inorder, int[] postorder){
        int len = inorder.length;
        map = new HashMap<>();
        for (int i = 0;i < len;i++){
            map.put(inorder[i], i);
        }
        return dfs(inorder, postorder, 0, len - 1, 0, len - 1);
    }

    private TreeNode dfs(int[] inorder, int[] postorder, int inLeft, int inRight, int postLeft, int postRight) {
        if (inLeft > inRight || postLeft > postRight){
            return null;
        }

        int rootIndex = map.get(postorder[postRight]);
        TreeNode root = new TreeNode(inorder[rootIndex]);
        int leftLen = rootIndex - inLeft;
        root.left = dfs(inorder, postorder, inLeft, rootIndex - 1, postLeft, postLeft + leftLen - 1);
        root.right = dfs(inorder, postorder, rootIndex + 1, inRight, postLeft + leftLen, postRight - 1);
        return root;
    }

    @Test
    public void test(){
        buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});
    }
}
