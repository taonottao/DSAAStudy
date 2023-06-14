import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/6/12 23:35
 */
public class Exer11 {
    /*
    获取二叉树的结点个数
     */
    public int size(TreeNode root){
        if(root == null){
            return 0;
        }
        int size = 1;
        size += size(root.left);
        size += size(root.right);
        return size;
    }

    public int size = 0;

    public int size2(TreeNode root){
        if(root == null){
            return 0;
        }
        size++;
        size2(root.left);
        size2(root.right);
        return size;
    }

    /*
    判断两颗二叉树是否相同
     */
    public boolean isSame(TreeNode p, TreeNode q){
        if(p == null && q != null || p != null && q == null){
            return false;
        }

        if(p == null && q == null){
            return true;
        }

        if(p.val != q.val){
            return false;
        }

        return isSame(p.left, q.left) && isSame(p.right, q.right);

    }

    /*
    二叉树的层序遍历
     */
    public void levelOrder1(TreeNode root){
        if(root == null) return;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        TreeNode cur = root;
        while (!queue.isEmpty()){
            cur = queue.poll();
            System.out.println(cur.val);
            if(cur.left != null) queue.offer(cur.left);
            if (cur.right != null) queue.offer(cur.right);
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();

        if(root == null) return list;

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        TreeNode cur = root;
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list1 = new ArrayList<>();
            while (size != 0) {
                cur = queue.poll();
                size--;
                list1.add(cur.val);
//                System.out.println(cur.val);

                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            list.add(list1);
        }
        return list;
    }
}
