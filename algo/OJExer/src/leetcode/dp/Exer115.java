package leetcode.dp;

/**
 * 不同的子序列
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/9/30 10:49
 */
public class Exer115 {
    public int numDistinct(String s, String t) {
        int m = t.length();
        int n = s.length();
        int[][] dp = new int[m+1][n+1];

        for(int j = 0; j <= n; j++){
            dp[0][j] = 1;
        }

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                dp[i][j] += dp[i][j-1];
                if(s.charAt(j-1) == t.charAt(i-1)){
                    dp[i][j] += dp[i-1][j-1];
                }
            }
        }
        return dp[m][n];
    }
}
