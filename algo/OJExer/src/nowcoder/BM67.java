package nowcoder;

/**
 * 不同路径的数目(一)
 * 递归
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/8/14 10:44
 */
public class BM67 {
    public int uniquePaths (int m, int n) {
        // write code here
        if(m == 1 || n == 1){
            return 1;
        }
        return uniquePaths(m-1, n) + uniquePaths(m, n-1);
    }
}
