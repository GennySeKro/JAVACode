package HOT100;

import UItilsClass.TreeNode;
import org.junit.Test;

public class HOT108 {
    /*
    将有序数组转化为二叉搜索树
     */

    public TreeNode sortedArrayToBST(int[] nums) {
        return array2BST(nums, 0, nums.length - 1);
    }

    private TreeNode array2BST(int[] nums, int start, int end) {
        if (start > end){
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode treeNode = new TreeNode(nums[mid]);

        treeNode.left = array2BST(nums, start, mid - 1);
        treeNode.right = array2BST(nums, mid + 1, end);

        return treeNode;
    }

    @Test
    public void test(){
        System.out.println(sortedArrayToBST(new int[]{-10,-3,0,5,9}));
    }
}
