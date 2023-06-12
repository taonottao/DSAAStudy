/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/6/12 16:40
 */
public class Exer9 {
    /*
    将一颗无穷大的满二叉树的结点, 按根结点一层一层的从左往右编号, 根节点编号为1.
    现给定a, b两个结点. 设计一个算法, 返回a, b公共祖先的编号
     */
    public int getLCA(int a, int b){
        while (a != b){
            if(a > b){
                a = a / 2;
            }else {
                b = b / 2;
            }
        }
        return a;
    }
}
