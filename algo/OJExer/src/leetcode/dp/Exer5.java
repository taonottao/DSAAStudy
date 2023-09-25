package leetcode.dp;

/**
 * 最长回文子串
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/9/24 9:58
 */
public class Exer5 {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int left = 0;
        int right = 0;
        for(int i = n - 1; i >= 0; i--){
            for(int j = i; j < n; j++){
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = i + 1 < j ? dp[i+1][j-1] : true;
                    if(dp[i][j]){
                        if(j - i > right - left){
                            left = i;
                            right = j;
                        }
                    }
                }

            }
        }
        return s.substring(left, right+1);
    }
}
