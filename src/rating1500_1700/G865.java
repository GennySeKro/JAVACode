package rating1500_1700;
import HOT.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class G865 {
    /*
    具有所有最深节点的最小子树
     */

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null) return root;

        // 获取当前节点的左右子树的最大深度
        int leftMaxDepth = getMaxDepth(root.left);
        int rightMaxDepth = getMaxDepth(root.right);

        // 如果两边最大深度相同，则这个节点就是结果
        if (leftMaxDepth == rightMaxDepth) return root;

        // 不相等，那就去深度大的子树那边继续找
        if (leftMaxDepth > rightMaxDepth){
            return subtreeWithAllDeepest(root.left);
        }

        return subtreeWithAllDeepest(root.right);
    }

    public int getMaxDepth(TreeNode root){
        if (root == null) return 0;

        return Math.max(getMaxDepth(root.left), getMaxDepth(root.right)) + 1;
    }
}
