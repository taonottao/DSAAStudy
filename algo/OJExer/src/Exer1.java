import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/4/23 21:07
 */

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Exer1 {
    /**
     * 输入一棵二叉搜索树，将其变为一个有序链表
     * @param pRootOfTree
     * @return
     */
    public TreeNode Convert(TreeNode pRootOfTree) {
        ConvertChild(pRootOfTree);
        TreeNode head = pRootOfTree;
        while (head !=  null && head.left != null){
            head = head.left;
        }
        return head;
    }

    TreeNode prev = null;

    public void ConvertChild(TreeNode pCur){
        if(pCur == null){
            return;
        }

        ConvertChild(pCur.left);

        pCur.left = prev;
        if(prev != null){
            prev = pCur;
        }
        prev.right = pCur;

//        System.out.print(pCur.val +  " ");

        ConvertChild(pCur.right);
    }
}
