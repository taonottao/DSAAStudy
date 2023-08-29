package nowcoder;

/**
 * 矩阵的最小路径和
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/8/28 8:35
 */
public class BM68 {
    public int minPathSum (int[][] matrix) {
        // write code here
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];
        for(int i = 0; i <= m; i++){
            dp[i][0] = Integer.MAX_VALUE;
        }
        for(int j = 0; j <= n; j++){
            dp[0][j] = Integer.MAX_VALUE;
        }
        dp[0][1] = 0;
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + matrix[i-1][j-1];
            }
        }
        return dp[m][n];
    }
}
