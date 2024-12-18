package HOT100;

import UItilsClass.TreeNode;

import java.util.ArrayList;

public class HOT98 {
    /*
    验证二叉搜索树
     */

    public boolean isValidBST(TreeNode root) {
        if (root.left == null && root.right == null){
            return true;
        }

        ArrayList<Integer> list = new ArrayList<>();
        midOrder(root, list);

        for (int i = 1;i < list.size();i++){
            if (list.get(i) <= list.get(i - 1)){
                return false;
            }
        }

        return true;

    }

    private void midOrder(TreeNode root, ArrayList<Integer> list) {
        if (root == null){
            return;
        }

        midOrder(root.left, list);
        list.add(root.val);
        midOrder(root.right, list);
    }
}
