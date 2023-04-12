package com.attao.java5;

import java.util.*;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/4/9 9:19
 */
public class BinaryTreeDemo {

    static class TreeNode{
        public char val;//数据域
        public TreeNode left;//左孩子
        public TreeNode right;//右孩子

        public TreeNode(char val) {
            this.val = val;
        }
    }

//    public TreeNode root;//二叉树的根节点

    public TreeNode creatTree(){
        TreeNode A = new TreeNode('A');
        TreeNode B = new TreeNode('B');
        TreeNode C = new TreeNode('C');
        TreeNode D = new TreeNode('D');
        TreeNode E = new TreeNode('E');
        TreeNode F = new TreeNode('F');
        TreeNode G = new TreeNode('G');
        TreeNode H = new TreeNode('H');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        E.right = H;
//        this.root = A;
        return A;
    }

    /**
     * 给一个字符串，根据前序遍历创建一颗二叉树，'#'代表空树
     */ public static int i = 0;

    public static TreeNode creatTree(String str){
        TreeNode root = null;
        if(str.charAt(i) != '#'){
            root = new TreeNode(str.charAt(i));
            i++;
            root.left = creatTree(str);
            root.right = creatTree(str);
        }else {
            i++;
        }
        return root;
    }

    //前序遍历 根  左子树  右子树
    public void preOrder(TreeNode root){
        if(root == null){
            return;
        }

        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public List<Character> preOrderTraversal(TreeNode root){
        List<Character> ret = new ArrayList<>();
        if(root == null){
            return ret;
        }
        ret.add(root.val);
        List<Character> leftTree = preOrderTraversal(root.left);
        ret.addAll(leftTree);
        List<Character> rightTree = preOrderTraversal(root.right);
        ret.addAll(rightTree);
        return ret;
    }

//    public List<Character> list = new LinkedList<>();
//    public List<Character> preOrderTraversal(TreeNode root){
//        if(root == null){
//            return null;
//        }
//
////        System.out.print(root.val + " ");
//        list.add(root.val);
//        preOrderTraversal(root.left);
//        preOrderTraversal(root.right);
//        return list;
//    }

    //中序遍历 左子树 根 右子树
    public void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    //后续遍历 左子树 右子树 根
    public void postOrder(TreeNode root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }

    //获取树中节点个数
    //时间复杂度：O(N)
    //空间复杂度：O(树的高度)
    public int size(TreeNode root){
//        int size = 1;
        if(root == null){
            return 0;
        }

        int leftSize = size(root.left);
//        size += leftSize;
        int  rightSize = size(root.right);
//        size += rightSize;
//        return size;
        return leftSize + rightSize + 1;
    }
    //获取树中节点个数
    private int size = 0;
    public int size1(TreeNode root){
        if(root == null){
            return 0;
        }
        size++;
        size1(root.left);
        size1(root.right);
        return size;
    }

    //获取叶子节点的个数
    public int getLeafNodeCount(TreeNode root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }

        int leftCount = getLeafNodeCount(root.left);
        int rightCount = getLeafNodeCount(root.right);
        return leftCount + rightCount;
    }

    public int leafCount;
    public void getLeafNodeCount1(TreeNode root){
        if(root == null){
            return ;
        }
        if(root.left == null && root.right == null){
            leafCount++;
        }

        getLeafNodeCount(root.left);
        getLeafNodeCount(root.right);
    }

    //获取第k层节点的个数
    public int getKLevelNodeCount(TreeNode  root, int k){
        if(root == null){
            return 0;
        }

        if(k == 1){
            return 1;
        }

        int leftCount = getKLevelNodeCount(root.left, k - 1);
        int rightCount = getKLevelNodeCount(root.right, k - 1);
        return leftCount + rightCount;
    }

    //获取二叉树的高度
    public int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftHeight =  getHeight(root.left);
        int rightHeight =  getHeight(root.right);
        return  (leftHeight > rightHeight) ? leftHeight + 1 : rightHeight + 1;

    }

    //检测值为value的元素是否存在
    public TreeNode find(TreeNode root, int val){
        if(root == null){
            return null;
        }
        if(root.val == val){
            return root;
        }
        TreeNode leftNode = find(root.left, val);
        if(leftNode != null){
            return leftNode;
        }
        TreeNode rightNode = find(root.right, val);
        if(rightNode != null){
            return rightNode;
        }
        return null;
    }

    /**
     * 判断两棵树是否完全相同
     * 时间复杂度:O(min(m,n))
     * 空间复杂度:O(min(m,n))
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q){
        if(p == null && q != null || p != null && q == null){
            return false;
        }

        if(p == null && q == null){
            return true;
        }

        if(p.val != q.val){
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

    }

    /**
     * 时间复杂度：O(s*t)
     * 空间复杂度：O(max(最大深度))
     * @param root
     * @param subRoot
     * @return
     */
    public boolean isSubTree(TreeNode root, TreeNode subRoot){
        if(root == null || subRoot == null){
            return false;
        }
        if(isSameTree(root, subRoot)){
            return true;
        }

        return isSubTree(root.left, subRoot) || isSameTree(root.right, subRoot);

    }

    //翻转二叉树，返回根节点
    public TreeNode invertTree(TreeNode root){
        if(root == null){
            return null;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }


    //判断一棵树是否为平衡二叉树

    /**
     * 时间复杂度：O(n^2)
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root){
        if(root == null){
            return true;
        }

        int leftH = getHeight(root.left);
        int rightH = getHeight(root.right);
        return Math.abs(leftH - rightH) < 2
        && isBalanced(root.left)
        && isBalanced(root.right);
    }
    /**
     * 时间复杂度：O(n)
     * @param root
     * @return
     */
    public boolean isBalanced1(TreeNode root){

//        return getH(root) >= 0;
        return getH1(root) >= 0;

    }

    public int getH(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftHeight =  getHeight(root.left);
        int rightHeight =  getHeight(root.right);

        if(leftHeight >= 0 && rightHeight >= 0
        && Math.abs(leftHeight - rightHeight) <= 1){
            return Math.max(leftHeight, rightHeight) + 1;
        }else {
            return -1;
        }

    }
    public int getH1(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftHeight =  getHeight(root.left);
        if(leftHeight < 0){
            return -1;
        }
        int rightHeight =  getHeight(root.right);
        if (rightHeight < 0){
            return -1;
        }

        if(Math.abs(leftHeight - rightHeight) <= 1){
            return Math.max(leftHeight, rightHeight) + 1;
        }else {
            return -1;
        }

    }

    //判断一棵树是否为轴对称
    public boolean isSymmetric(TreeNode root){
        if(root == null){
            return true;
        }
        return isSymmetricChild(root.left, root.right);

    }

    public boolean isSymmetricChild(TreeNode leftTree, TreeNode rightTree){
        if(leftTree == null && rightTree != null || leftTree != null && rightTree == null){
            return false;
        }
        if(leftTree == null && rightTree == null){
            return true;
        }

        if(leftTree.val != rightTree.val){
            return false;
        }

        return isSymmetricChild(leftTree.left, rightTree.right)
                && isSymmetricChild(leftTree.right, rightTree.left);
    }

    //层序遍历
    public void levelOrder(TreeNode root){
        if(root == null){
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (! queue.isEmpty()){
            TreeNode cur = queue.poll();
            System.out.print(cur.val + " ");
            if(cur.left != null){
                queue.offer(cur.left);
            }
            if(cur.right != null){
                queue.offer(cur.right);
            }
        }
    }

    public List<List<Character>> levelOrder2(TreeNode root){
        List<List<Character>> list = new ArrayList<>();
        if(root == null){
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        while (! queue.isEmpty()){
            int size = queue.size();
            List<Character> tmp = new ArrayList<>();
            while (size != 0){

                TreeNode cur = queue.poll();
//                System.out.print(cur.val + " ");
                tmp.add(cur.val);
                size--;
                if(cur.left != null){
                    queue.offer(cur.left);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                }

            }

            list.add(tmp);
        }
        return list;
    }


    /**
     * 找到二叉树中两个指定节点的最近公共祖先
     */
    //方法一：
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return null;
        }
        //先判断根节点是不是其中一个
        if(root == p || root == q){
            return root;
        }

        TreeNode leftRet = lowestCommonAncestor(root.left, p, q);
        TreeNode rightRet = lowestCommonAncestor(root.right, p, q);

        if(leftRet != null && rightRet != null){
            return root;
        } else if (leftRet != null) {
            return leftRet;
        } else if (rightRet != null) {
            return rightRet;
        }

        return null;
    }

    //方法二：
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q){
        //1.两个栈中储存好数据
        Deque<TreeNode> stack1 = new LinkedList<>();
        getPath(root, p, stack1);
        Deque<TreeNode> stack2 = new LinkedList<>();
        getPath(root, q, stack2);
        //判断栈的大小
        int size1 = stack1.size();
        int size2 = stack2.size();
        if(size1 > size2){
            int size = size1 - size2;
            while (size != 0){
                stack1.pop();
                size--;
            }
        }else {
            int size = size2 - size1;
            while (size != 0){
                stack2.pop();
                size--;
            }
        }
        //此时栈里的数据个数一样
        while (!stack1.isEmpty() && !stack2.isEmpty()){
            if(stack1.peek() != stack2.peek()){
                stack1.pop();
                stack2.pop();
            }else {
                return stack1.peek();
            }
        }
        return null;
    }
    /**
     * 找到从根节点到指定节点node路径上的所有的节点，存放到栈当中
     */
    public boolean getPath(TreeNode root, TreeNode node, Deque<TreeNode> stack){
        if(root == null || node == null){
            return false;
        }
        stack.push(root);
        //放完之后，要检查
        if(root == node){
            return true;
        }
        boolean ret1 = getPath(root.left, node, stack);
        if(ret1){
            return true;
        }
        boolean ret2 = getPath(root.left, node, stack);
        if(ret2){
            return true;
        }
        stack.pop();
        return false;
    }


    /**
     * 根据前序遍历和中序遍历构造一颗二叉树
     *
     */
    public int i1 = 0;
    public TreeNode buildTree(char[] preorder, char[] inorder){
        return buildTreeChild(preorder, inorder, 0, inorder.length - 1);
    }
    public TreeNode buildTreeChild(char[] preorder, char[] inorder, int inbegin, int inend){
        if(inbegin > inend){
            return null;
        }

        TreeNode root = new TreeNode(preorder[i]);

        //找到当前根在中序遍历中的位置
        int rootIndex = findIndex(inorder, inbegin, inend, preorder[i]);
        i++;

        root.left = buildTreeChild(preorder, inorder, inbegin, rootIndex - 1);
        root.right = buildTreeChild(preorder, inorder, rootIndex + 1, inend);
    }
    private int findIndex(char[] inorder, int inbegin, int inend, char key){
        int j;
        for (j = inbegin; j < inend + 1; j++) {
            if(inorder[j] == key){
                return j;
            }
        }
        return -1;
    }

    /**
     * 根据二叉树创建字符串
     * 力扣题
     */
    public String tree2str(TreeNode root){
        if(root == null){
            return null;
        }
        StringBuilder stringBuilder  = new StringBuilder();

    }
    public void tree2strChilde(TreeNode t, StringBuilder stringBuilder){
        if(t == null){
            return;
        }
        stringBuilder.append(t.val);
        if(t.left != null){
            stringBuilder.append("(");
            tree2strChilde(t.left, stringBuilder);
            stringBuilder.append(")");
        }else {
            //左边为空
            if(t.right != null){
                stringBuilder.append("()");
            }else {
                return;
            }
        }

        if(t.right == null){
            return;
        }else {
            stringBuilder.append("(");
            tree2strChilde(t.right, stringBuilder);
            stringBuilder.append(")");
        }
    }

}
