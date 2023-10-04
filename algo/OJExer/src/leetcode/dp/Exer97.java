package leetcode.dp;

/**
 * 交错字符串
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/10/3 12:33
 */
public class Exer97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        if(m+n != s3.length()){
            return false;
        }
        s1 = " " + s1;
        s2 = " " + s2;
        s3 = " " + s3;

        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;

        for(int j = 1; j <= n; j++){
            if(s2.charAt(j) == s3.charAt(j)){
                dp[0][j] = true;
            }else{
                break;
            }
        }
        for(int i = 1; i <= m; i++){
            if(s1.charAt(i) == s3.charAt(i)){
                dp[i][0] = true;
            }else{
                break;
            }
        }

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                dp[i][j] = (s1.charAt(i) == s3.charAt(i+j) && dp[i-1][j])
                        || (s2.charAt(j) == s3.charAt(i+j) && dp[i][j-1]);
            }
        }
        return dp[m][n];
    }
}
