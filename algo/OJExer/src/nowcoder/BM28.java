package nowcoder;

/**
 * 二叉树的最大深度
 *
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/8/22 12:14
 */

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class BM28 {
    public int maxDepth(TreeNode root) {
        // write code here
        if (root == null) return 0;
        int left = maxDepth(root.left) + 1;
        int right = maxDepth(root.right) + 1;

        return Math.max(left, right);
    }
}
