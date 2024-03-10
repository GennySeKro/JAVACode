package LCR;
import HOT.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class LCR124 {

    /*
    推理二叉树
     */

    public TreeNode deduceTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0;i < inorder.length;i++){
            map.put(inorder[i], i);
        }

        return dfs(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1, map);
    }

    private TreeNode dfs(int[] preorder, int[] inorder, int preSart, int preEnd, int inStart, int inEnd, Map<Integer, Integer> map) {
        if (preSart > preEnd || inStart > inEnd){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preSart]);
        int leftLen = map.get(preorder[preSart]) - inStart;
        root.left = dfs(preorder, inorder, preSart + 1, preSart + leftLen, inStart,  map.get(preorder[preSart])- 1, map);
        root.right = dfs(preorder, inorder, preSart + leftLen + 1, preEnd, map.get(preorder[preSart]) + 1, inEnd, map);
        return root;
    }
}
