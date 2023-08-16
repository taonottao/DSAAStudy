package leetcode;

/**
 * 礼物的最大价值
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/8/15 10:01
 */
public class Offer47 {
    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m+1][n+1];

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++) {
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + grid[i-1][j-1];
            }
        }

        return dp[m][n];
    }
}
