package Demo1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/7/6 20:20
 */
public class Exer3 {
    /**
     * 根据二叉树创建字符串（力扣）
     */
    public String tree2str(TreeNode root) {
        if(root == null) return null;
        StringBuilder str = new StringBuilder();
        tree2strChild(root, str);
        return str.toString();
    }

    public void tree2strChild(TreeNode root, StringBuilder str){
        if(root == null) return;
        str.append(root.val);
        if(root.left != null){
            str.append("(");
            tree2strChild(root.left, str);
            str.append(")");
        }else{
            if(root.right == null){
                return;
            }else{
                str.append("()");
            }
        }
        if(root.right != null){
            str.append("(");
            tree2strChild(root.right, str);
            str.append(")");
        }else{
            return;
        }
    }


    /**
     * 判断一棵树是否为完全二叉树
     */
    public boolean isCompleteTree(TreeNode root){
        if(root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if(cur != null){
                queue.offer(cur.left);
                queue.offer(cur.right);
            }else {
                break;
            }
        }
        while (!queue.isEmpty()){
            TreeNode tmp = queue.poll();
            if (tmp != null) {
                return false;
            }
        }
        return true;
    }
}
