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

    /**
     * 插入val
     * @param val
     */
    public void insert(int val){
        if(root ==  null){
            root = new TreeNode(val);
            return;
        }
        TreeNode cur = root;
        TreeNode parent = null;
        while (cur != null){
            parent = cur;
            if(cur.val > val){
                cur = cur.left;
            } else if (cur.val == val) {
                return;
            } else{
                cur = cur.right;
            }
        }
        cur = new TreeNode(val);
        if(parent.val > val){
            parent.left = cur;
        }else {
            parent.right = cur;
        }
    }

    /**
     * 中序遍历
     * @param root
     */
    public void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    /**
     * 删除值为val的节点
     * @param val
     */
    public void remove(int val){
        TreeNode cur = root;
        TreeNode parent = null;
        while (cur != null){
            if(cur.val == val){
                removeNode(parent, cur);
            } else if (cur.val < val) {
                parent = cur;
                cur = cur.right;
            }else {
                parent = cur;
                cur = cur.left;
            }
        }
    }

    private void removeNode(TreeNode parent, TreeNode cur) {

        if(cur.left == null){
            if(cur == root){
                root = cur.right;
            } else if (parent.left == cur) {
                parent.left = cur.right;
            }else {
                parent.right = cur.right;
            }
        } else if (cur.right == null) {
            if(cur == root){
                root = cur.left;
            } else if (parent.left == cur) {
                parent.left = cur.left;
            }else {
                parent.right = cur.left;
            }
        }else {
            TreeNode target = cur.right;
            TreeNode targetParent = cur;
            while (target.left != null){
                targetParent = target;
                target = target.left;
            }
            cur.val = target.val;
            if(target == targetParent.left){
                targetParent.left = target.right;
            }else {
                targetParent.right = target.right;
            }
        }

    }


}
