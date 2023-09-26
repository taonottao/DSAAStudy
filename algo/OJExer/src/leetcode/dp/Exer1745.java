package leetcode.dp;

/**
 * 分割回文串 IV
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/9/25 11:16
 */
public class Exer1745 {
    public boolean checkPartitioning(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for(int i = n - 1; i >= 0; i--){
            for(int j = i; j < n; j++){
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = i + 1 < j ? dp[i+1][j-1] : true;
                }
            }
        }

        for(int i = 1; i < n - 1; i++){
            for(int j = i; j < n - 1; j++){
                if(dp[0][i - 1] && dp[i][j] && dp[j+1][n-1]){
                    return true;
                }
            }
        }
        return false;
    }
}
