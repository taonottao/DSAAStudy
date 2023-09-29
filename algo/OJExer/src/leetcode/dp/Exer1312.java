package leetcode.dp;

/**
 * 让字符串成为回文串的最少插入次数
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/9/28 10:46
 */
public class Exer1312 {
    public int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {

            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1], dp[i + 1][j]) + 1;
                }
            }
        }
        return dp[0][n - 1];

    }
}