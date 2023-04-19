import org.junit.Test;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/4/18 22:53
 */
public class SearchTreeTest {

    @Test
    public void test1(){
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(12);
        binarySearchTree.insert(21);
        binarySearchTree.insert(5);
        binarySearchTree.insert(18);
        binarySearchTree.insert(9);

        binarySearchTree.inOrder(binarySearchTree.root);

        System.out.println();

        BinarySearchTree.TreeNode ret = binarySearchTree.findVal(12);
        System.out.println(ret.val);

        binarySearchTree.remove(13);
        binarySearchTree.inOrder(binarySearchTree.root);
    }

}
