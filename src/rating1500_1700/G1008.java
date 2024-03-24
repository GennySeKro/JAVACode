package rating1500_1700;
import HOT.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class G1008 {
    /*
    前序遍历构造二叉搜索树
     */

    public TreeNode bstFromPreorder(int[] preorder) {
        int len = preorder.length;
        Map<Integer, Integer> hashMap = new HashMap<>();

        int[] inorder = new int[len];
        System.arraycopy(preorder, 0, inorder, 0, len);
        Arrays.sort(inorder);

        int index = 0;
        for (Integer value : inorder) {
            hashMap.put(value, index);
            index++;
        }
        return dfs(0, len - 1, 0, len - 1, preorder, hashMap);
    }

    public TreeNode dfs(int preLeft, int preRight, int inLeft, int inRight, int[] preorder, Map<Integer, Integer> hashMap) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        int pivot = preorder[preLeft];
        TreeNode root = new TreeNode(pivot);
        int pivotIndex = hashMap.get(pivot);
        root.left = dfs(preLeft + 1, pivotIndex - inLeft + preLeft,
                inLeft, pivotIndex - 1, preorder, hashMap);
        root.right = dfs(pivotIndex - inLeft + preLeft + 1, preRight,
                pivotIndex + 1, inRight, preorder, hashMap);
        return root;
    }
}
