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

    public int uniquePaths1 (int m, int n) {
        // write code here
        int[][] dp = new int[m+1][n+1];
        dp[0][1] = 1;
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m][n];
    }

}
