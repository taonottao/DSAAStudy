package leetcode.dp;

/**
 * 分割回文串 II
 *
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/9/25 11:35
 */
public class Exer132 {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] isPal = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    isPal[i][j] = i + 1 < j ? isPal[i + 1][j - 1] : true;
                }
            }
        }
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < n; i++) {
            if (isPal[0][i]) {
                dp[i] = 0;
            } else {
                for (int j = 1; j <= i; j++) {
                    if (isPal[j][i]) {
                        dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                    }
                }
            }

        }
        return dp[n - 1];
    }
}
