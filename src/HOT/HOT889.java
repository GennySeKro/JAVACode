package HOT;

import java.util.HashMap;
import java.util.Map;

public class HOT889 {
    /*
    根据前序和后序遍历构造二叉树
     */

    Map<Integer, Integer> map;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        map = new HashMap<>();
        for (int i = 0;i < postorder.length;i++){
            map.put(postorder[i], i);
        }
        return dfs(preorder, postorder, 0, preorder.length - 1, 0, preorder.length - 1);
    }

    private TreeNode dfs(int[] preorder, int[] postorder, int preLeft, int preRight, int postLeft, int postRight) {
        if (preLeft > preRight){
            return null;
        }

        int leftCount = 0;
        if (preLeft < preRight){
            leftCount = map.get(preorder[preLeft + 1]) - postLeft + 1;
        }
        TreeNode root = new TreeNode(preorder[preLeft]);
        root.left = dfs(preorder, postorder, preLeft + 1, preLeft + leftCount, postLeft, postLeft + leftCount - 1);
        root.right = dfs(preorder, postorder, preLeft + leftCount + 1, preRight, postLeft + leftCount, postRight - 1);
        return  root;
    }

}
