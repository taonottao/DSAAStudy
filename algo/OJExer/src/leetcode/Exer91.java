package leetcode;

/**
 * 解码方法
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/8/13 14:46
 */
public class Exer91 {
    public int numDecodings(String ss) {
        int n = ss.length();
        char[] s = ss.toCharArray();
        int[] dp = new int[n + 1];

        dp[0] = 1;
        if(s[1-1] != '0') dp[1] = 1;

        for(int i = 2; i <= n; i++){
            if(s[i-1] != '0') dp[i] += dp[i-1];
            int tt = (s[i-2] - '0') * 10 + s[i-1] - '0';
            if(tt >= 10 && tt <= 26) dp[i] += dp[i-2];
        }
        return dp[n];
    }
}
