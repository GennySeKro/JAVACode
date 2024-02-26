package HOT;

public class HOT108 {
    /*
       将有序数组转换为二叉搜索树
     */

    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int start, int end) {
        if (end >= start){
            int mid = (start + end) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = dfs(nums, start, mid - 1);
            root.right = dfs(nums, mid + 1, end);
            return root;
        }else {
            return null;
        }
    }
}
