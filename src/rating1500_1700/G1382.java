package rating1500_1700;
import HOT.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class G1382 {
    /*
    将二叉搜索树变平衡
     */

    public TreeNode balanceBST(TreeNode root){
        List<Integer> sortList = new ArrayList<>();
        // 中序遍历构造有序链表
        inOrder(root,sortList);
        // 有序链表构造平衡二叉树
        return buildTree(sortList,0,sortList.size()-1);
    }

    private void inOrder(TreeNode node,List<Integer> sortList){
        if (node != null){
            inOrder(node.left,sortList);
            sortList.add(node.val);
            inOrder(node.right,sortList);
        }
    }

    //有序链表构造平衡二叉树
    private TreeNode buildTree(List<Integer> sortList, int start, int end) {
        if (start > end){
            return null;
        }
        // 中间节点为root
        int mid = start + (end - start >> 1);
        TreeNode root = new TreeNode(sortList.get(mid));
        // 递归构造左右子树
        root.left = buildTree(sortList,start,mid-1);
        root.right = buildTree(sortList,mid+1,end);
        // 返回root
        return root;
    }
}
