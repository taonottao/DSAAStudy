package Demo1;

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
}
