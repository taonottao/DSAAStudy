package nowcoder;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 二叉树层序遍历
 *
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/8/22 16:04
 */

//class TreeNode {
//    int val = 0;
//    TreeNode left = null;
//    TreeNode right = null;
//
//    public TreeNode(int val) {
//        this.val = val;
//    }
//}

public class BM26 {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // write code here
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode cur = root;
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int size = queue.size();
            while (size > 0) {
                cur = queue.poll();
                list.add(cur.val);
                size--;
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            lists.add(list);
        }

        return lists;
    }
}
