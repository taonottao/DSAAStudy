/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/4/18 22:53
 */
public class BinarySearchTree {

    static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    TreeNode root = null;
    /**
     * 查找二叉搜索树中指定的val值
     * @param val
     * @return
     */
    public TreeNode findVal(int val){
        TreeNode cur = root;
        while (cur != null){
            if(val > cur.val){
                cur =  cur.right;
            } else if (val < cur.val) {
                cur = cur.left;
            }else {
                return cur;
            }
        }
        return null;
    }

}
