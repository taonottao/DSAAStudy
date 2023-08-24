package leetcode;

/**
 * 粉刷房子
 *
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/8/23 11:27
 */
public class LCR091 {
    public int minCost(int[][] costs) {
        int m = costs.length;
        int n = 3;
        int[][] dp = new int[m + 1][n + 2];
        for (int i = 0; i <= n + 1; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i <= m; i++) {
            dp[i][0] = dp[i][n + 1] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= 3; j++) {
                if (j == 1) {
                    dp[i][j] = Math.min(dp[i - 1][2], dp[i - 1][3]) + costs[i - 1][j - 1];
                } else if (j == 2) {
                    dp[i][j] = Math.min(dp[i - 1][1], dp[i - 1][3]) + costs[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][2], dp[i - 1][1]) + costs[i - 1][j - 1];
                }
            }
        }

        return Math.min(dp[m][1], Math.min(dp[m][2], dp[m][3]));
    }
}
