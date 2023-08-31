package leetcode.dp;

/**
 * 地下城游戏
 *
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/8/16 14:25
 */
public class Exer174 {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = m; i >= 0; i--) {
            dp[i][n] = Integer.MAX_VALUE;
        }
        for (int i = n; i >= 0; i--) {
            dp[m][i] = Integer.MAX_VALUE;
        }
        dp[m][n - 1] = dp[m - 1][n] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
                if (dp[i][j] <= 0) dp[i][j] = 1;
            }
        }
        return dp[0][0];
    }
}
