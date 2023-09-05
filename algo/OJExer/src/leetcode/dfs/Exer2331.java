package leetcode.dfs;


/**
 * 计算布尔二叉树的值
 *
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/9/4 10:41
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Exer2331 {
    public boolean evaluateTree(TreeNode root) {
        if (root.left == null) {
            return root.val == 0 ? false : true;
        }
        boolean left = evaluateTree(root.left);
        boolean right = evaluateTree(root.right);

        return root.val == 2 ? left || right : left && right;
    }
}
