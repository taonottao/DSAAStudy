package exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/9/4 19:01
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class demo1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int a = 1, b = 1, c = 0, d = 0, e = 1;
            for(a = 2; a <= n; a++){
                b = (int)((b + e) % (1e9+7));
                int tmp  = e;
                e += d;
                d = c;
                c = tmp;
            }
            // 1 2 3 4 6 9 13 16
            System.out.println(b);
        }
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        // write code here
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            delete (root);
        }
        TreeNode left = deleteNode(root.left, key);
        TreeNode right = deleteNode(root.right, key);
        if (left != null) {
            root.left = left;
        } else if (right != null) {
            root.right = right;
        }
        return root;
    }

    private TreeNode delete (TreeNode root) {
        if (root.left == null && root.right == null) {
            return null;
        } else if (root.left == null) {
            TreeNode right = root.right;
            // root = null;
            return right;
        } else if (root.right == null) {
            TreeNode left = root.left;
            // root = null;
            return left;
        } else {
            TreeNode left = root.left;
            TreeNode right = root.right;
            while(right.left != null){
                right = right.left;
            }
            right.left = left;

            return root;
        }
    }

}
