package leetcode.dp;

/**
 * 回文子串
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/9/24 9:14
 */
public class Exer647 {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        int count = 0;
        for(int i = n - 1; i >= 0; i--){
            for(int j = i; j < n; j++){
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = i + 1 < j ? dp[i+1][j-1] : true;
                    if(dp[i][j]){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
