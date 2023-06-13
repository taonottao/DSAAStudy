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
}
