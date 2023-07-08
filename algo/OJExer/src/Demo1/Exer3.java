package Demo1;

import java.util.*;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/7/6 20:20
 */
public class Exer3 {
    public static void main(String[] args) {
//        double d = 1.2333;
////        char c = '\0';
//        System.out.printf("%.2f\\%", (10/3.0)*100);
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String a = in.nextLine();
            String b = in.nextLine();
            List<String> list = new ArrayList<>();
            for(int i = 0; i < a.length(); i++){
                String str = "";
                if(a.charAt(i) == '"'){
                    i++;
                    while(a.charAt(i)!='"'){
                        str+= a.charAt(i);
                    }
                    list.add(str);
                }else{
                    while(i < a.length() && a.charAt(i)!=','){
                        str += a.charAt(i);
                        i++;
                    }
                    list.add(str);
                }
            }
            if(list.contains(b)){
                System.out.println("Ignore");
            }else{
                System.out.println("Important!");
            }

        }
    }
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
