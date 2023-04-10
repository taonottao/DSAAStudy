package com.attao.java5;

import org.junit.Test;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/4/9 9:36
 */
public class BinaryTreeTest {

    @Test
    public void test1(){
        BinaryTreeDemo binaryTree = new BinaryTreeDemo();
        BinaryTreeDemo.TreeNode root = binaryTree.creatTree();
        System.out.println("==================");
        binaryTree.preOrder(root);
        System.out.println();
        binaryTree.inOrder(root);
        System.out.println();
        binaryTree.postOrder(root);
        System.out.println();
        System.out.println("==================");

        System.out.println(binaryTree.size(root));
        System.out.println(binaryTree.size1(root));
        System.out.println("==================");
        System.out.println(binaryTree.getLeafNodeCount(root));
        System.out.println("==================");
        System.out.println(binaryTree.getKLevelNodeCount(root, 3));
        System.out.println("==================");
        System.out.println(binaryTree.getHeight(root));

    }

}
