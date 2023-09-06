package leetcode.dfs;

/**
 * 二叉树剪枝
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/9/5 10:22
 */
public class Exer814 {
    public TreeNode pruneTree(TreeNode root) {
        if(root == null){
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if(root.left == null && root.right == null && root.val == 0){
            root = null;
        }
        return root;
    }
}
