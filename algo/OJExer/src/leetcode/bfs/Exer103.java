package leetcode.bfs;

import java.util.*;

/**
 * 二叉树的锯齿形层序遍历
 *
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/10/17 22:47
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

public class Exer103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) return ret;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 1;
        while (!q.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            int sz = q.size();
            while (sz > 0) {
                TreeNode t = q.poll();
                tmp.add(t.val);
                if (t.left != null) {
                    q.add(t.left);
                }
                if (t.right != null) {
                    q.add(t.right);
                }
                sz--;
            }
            if (level % 2 == 0) {
                Collections.reverse(tmp);
            }
            level++;
            ret.add(tmp);
        }
        return ret;
    }
}
