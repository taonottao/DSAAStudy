package leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的所有路径
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/9/10 9:48
 */
public class Exer257 {
    List<String> list = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        StringBuilder path = new StringBuilder();
        dfs(root, path);
        return list;
    }

    private void dfs(TreeNode root, StringBuilder _path){
        StringBuilder path = new StringBuilder(_path);
        path.append(root.val);
        if(root.left == null && root.right == null){

            list.add(path.toString());
            return;
        }
        path.append("->");
        if(root.left != null){
            dfs(root.left, path);
        }
        if(root.right != null)
            dfs(root.right, path);
    }
}
