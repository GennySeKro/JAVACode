package HOT100;

import UItilsClass.TreeNode;
import com.sun.source.tree.Tree;

import java.util.HashMap;

public class HOT105 {
    /*
    从前序与中序遍历序列构造二叉树
     */

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0;i < inorder.length;i++){
            map.put(inorder[i], i);
        }

        return buildTree(preorder, 0, inorder.length, 0, inorder.length, map);
    }

    private TreeNode buildTree(int[] preorder, int preL, int preR, int inL, int inR, HashMap<Integer, Integer> map) {
        if (preL == preR){
            return null;
        }

        int leftSize = map.get(preorder[preL]) - inL;
        TreeNode left = buildTree(preorder, preL + 1, preL + 1 + leftSize, inL, inL + leftSize, map);
        TreeNode right = buildTree(preorder, preL + 1 + leftSize, preR, inL + 1 + leftSize, inR, map);

        return new TreeNode(preorder[preL], left, right);
    }
}
