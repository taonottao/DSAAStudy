package nowcoder;

/**
 * 最长公共子串
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/10/3 9:46
 */
public class BM66 {
    public String LCS (String s1, String s2) {
        // write code here
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m+1][n+1];
        int maxLen = 0;
        int index = 0;
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    if(dp[i][j] > maxLen){
                        maxLen = dp[i][j];
                        index = i;
                    }
                }
            }
        }
        return s1.substring(index - maxLen, index);
    }
}
