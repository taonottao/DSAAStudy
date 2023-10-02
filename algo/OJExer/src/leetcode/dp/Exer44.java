package leetcode.dp;

/**
 * 通配符匹配
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/10/1 9:35
 */
public class Exer44 {
    public boolean isMatch(String ss, String pp) {
        int m = ss.length();
        int n = pp.length();
        ss = " "+ss;
        pp = " " + pp;
        char[] s = ss.toCharArray();
        char[] p = pp.toCharArray();

        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for(int j = 1; j <= n; j++){
            if(p[j] == '*'){
                dp[0][j] = true;
            }else{
                break;
            }
        }
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(p[j] == '*'){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }else{
                    dp[i][j] = (p[j] == '?' || p[j] == s[i]) && dp[i-1][j-1];
                }
            }
        }

        return dp[m][n];
    }
}
