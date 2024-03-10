package LCR;

import HOT.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LCR143 {
    /*
    子结构判断
     */

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }
    boolean recur(TreeNode A, TreeNode B) {
        if(B == null) return true;
        if(A == null || A.val != B.val) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }


    @Test
    public void test(){
        TreeNode rootA = new TreeNode(1);
        rootA.left = new TreeNode(7);
        rootA.right = new TreeNode(5);
        TreeNode rootB = new TreeNode(6);
        rootB.left = new TreeNode(1);
        isSubStructure(rootA, rootB);
    }
}
