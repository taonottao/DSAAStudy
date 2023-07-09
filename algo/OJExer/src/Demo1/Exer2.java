package Demo1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/7/5 23:56
 */

class TreeNode {
  int val = 0;
  TreeNode left = null;
  TreeNode right = null;
  public TreeNode(int val) {
    this.val = val;
  }
}

public class Exer2 {
    public static void main(String[] args) {
        System.out.println("%");
    }
    /**
     * 给定一个二叉树的中序与后序遍历结果，请你根据两个序列构造符合这两个序列的二叉树。
     *  保证节点的值各不相同
     */
    int i = 0;
    public TreeNode buildTree (int[] inorder, int[] postorder) {
        // write code here
        i = inorder.length - 1;
        TreeNode root = buildChildTree(inorder, postorder, 0, inorder.length-1);
        return root;
    }
    public TreeNode buildChildTree(int[] inorder, int[] postorder, int inbegin, int inend){
        if(inbegin > inend) return null;

        TreeNode root = new TreeNode(postorder[i]);
        int index = findRoot(inorder, inbegin, inend, postorder[i]);
        i--;
        root.right = buildChildTree(inorder, postorder, index + 1, inend);
        root.left = buildChildTree(inorder, postorder, inbegin, index - 1);


        return root;
    }
    public int findRoot(int[] inorder, int inbegin, int inend, int val){
        for(int i = inbegin; i <= inend; i++){
            if(inorder[i] == val) return i;
        }
        return -1;
    }

    /**
     * 中序遍历非递归实现
     */
    public int[] inorderTraversal (TreeNode root) {
        // write code here
        if(root == null) {
            int[] sb = new int[]{};
            return sb;
        }
        List<TreeNode> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode top = stack.pop();
            list.add(top);
            cur = top.right;
        }
        int[] arr = new int[list.size()];
        int i = 0;
        for(TreeNode tmp : list){
            arr[i++] = tmp.val;
        }

        return arr;
    }

    /**
     * 后序遍历非递归
     */
    public int[] postorderTraversal (TreeNode root) {
        // write code here
        if(root == null){
            int[] sb = new int[]{};
            return sb;
        }
        List<TreeNode> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        while(cur!=null || !stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode top = stack.peek();
            if(top.right != null && top.right != prev){
                cur = top.right;
            }else{
                list.add(top);
                prev = top;
                stack.pop();
            }
        }

        int[] arr = new int[list.size()];
        int i = 0;
        for(TreeNode tmp : list){
            arr[i++] = tmp.val;
        }

        return arr;
    }
}
