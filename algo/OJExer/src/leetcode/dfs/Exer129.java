package leetcode.dfs;

/**
 * 求根节点到叶节点数字之和
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/9/5 10:05
 */
public class Exer129 {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int preSum){
        preSum = preSum * 10 + root.val;
        if(root.left == null && root.right == null){
            return preSum;
        }
        int ret = 0;
        if(root.left != null){
            ret += dfs(root.left, preSum);
        }
        if(root.right != null){
            ret += dfs(root.right, preSum);
        }
        return ret;
    }
}
