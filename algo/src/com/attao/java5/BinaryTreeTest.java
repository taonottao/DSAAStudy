package com.attao.java5;

import org.junit.Test;

import java.util.Scanner;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/4/9 9:36
 */
public class BinaryTreeTest {

    public static void main(String[] args) {
        BinaryTreeDemo binaryTree = new BinaryTreeDemo();
        Scanner in = new Scanner(System.in);
        //注意hasNext 和 hasNextLine的区别
        while(in.hasNextLine()){
            BinaryTreeDemo.i = 0;
            String str = in.nextLine();
            BinaryTreeDemo.TreeNode root =BinaryTreeDemo.creatTree(str);
            binaryTree.inOrder(root);
        }
//        BinaryTreeDemo.TreeNode root =BinaryTreeDemo.creatTree("abc##de#g##f###");
//        binaryTree.inOrder(root);
    }

    @Test
    public void test1(){
        BinaryTreeDemo binaryTree = new BinaryTreeDemo();
        BinaryTreeDemo.TreeNode root = binaryTree.creatTree();
        System.out.println("==================");
//        binaryTree.preOrder(root);
//        System.out.println();
//        binaryTree.preOrderNor(root);
//        System.out.println();
        System.out.println("==================");
//        binaryTree.levelOrder(root);
//        binaryTree.inOrder(root);
//        System.out.println();
//        binaryTree.inOrderNor(root);
        binaryTree.postOrder(root);
        System.out.println();
        binaryTree.postOrderNor(root);
//        System.out.println("==================");
//
//        System.out.println(binaryTree.size(root));
//        System.out.println(binaryTree.size1(root));
//        System.out.println("==================");
//        System.out.println(binaryTree.getLeafNodeCount(root));
//        System.out.println("==================");
//        System.out.println(binaryTree.getKLevelNodeCount(root, 3));
//        System.out.println("==================");
//        System.out.println(binaryTree.getHeight(root));

    }



}
