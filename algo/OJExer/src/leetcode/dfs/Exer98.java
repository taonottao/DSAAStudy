package leetcode.dfs;

/**
 *  验证二叉搜索树
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/9/9 8:30
 */
public class Exer98 {
    long prev = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        boolean left = isValidBST(root.left);

        // 剪枝
        if (left == false) {
            return false;
        }

        boolean cur = false;
        if(prev < root.val){
            cur = true;
        }

        // 剪枝
        if (cur == false) {
            return false;
        }

        prev = root.val;
        boolean right = isValidBST(root.right);
        return left && cur && right;
    }
}
