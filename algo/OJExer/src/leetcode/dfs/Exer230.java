package leetcode.dfs;

/**
 * 二叉搜索树中第K小的元素
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/9/9 9:01
 */
public class Exer230 {
    int count;
    int ret;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        dfs(root);
        return ret;
    }

    private void dfs(TreeNode root){
        if(root == null){
            return;
        }
        if(count <= 0){
            return;
        }
        dfs(root.left);
        count--;
        if(count == 0){
            ret = root.val;
            return;
        }
        dfs(root.right);
    }
}
