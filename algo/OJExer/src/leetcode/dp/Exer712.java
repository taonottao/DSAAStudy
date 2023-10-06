package leetcode.dp;

/**
 * 两个字符串的最小ASCII删除和
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/10/5 10:23
 */
public class Exer712 {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m+1][n+1];

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + s1.charAt(i-1));
                }
            }
        }
        int sum = 0;
        for(char ch : s1.toCharArray()){
            sum += ch;
        }
        for(char ch : s2.toCharArray()){
            sum += ch;
        }
        return sum - 2 * dp[m][n];
    }
}
