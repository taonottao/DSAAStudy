package com.attao.java5;

import java.util.ArrayList;
import java.util.List;

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

    private int leafCount;
    public void getLeafNodeCount1(TreeNode root){
        if(root == null){
            return ;
        }
        if(root.left == null && root.right == null){
            leafCount++;
        }

        int leftCount = getLeafNodeCount(root.left);
        int rightCount = getLeafNodeCount(root.right);
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


}
