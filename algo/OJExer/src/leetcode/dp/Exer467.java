package leetcode.dp;

/**
 * 环绕字符串中唯一的子字符串
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/8/30 9:49
 */
public class Exer467 {
    public int findSubstringInWraproundString(String ss) {
        int n = ss.length();
        char[] s = ss.toCharArray();
        int[] dp = new int[n];
        for(int i = 0; i < n; i++){
            dp[i] = 1;
        }
        for(int i = 1; i < n; i++){
            if(s[i-1] + 1 == s[i] || (s[i-1] == 'z' && s[i] == 'a')){
                dp[i] += dp[i-1];
            }
        }
        int[] hash = new int[26];
        for(int i = 0; i < n; i++){
            hash[s[i] - 'a'] = Math.max( hash[s[i] - 'a'], dp[i]);
        }
        int sum = 0;
        for(int i = 0; i < 26; i++){
            sum += hash[i];
        }
        return sum;
    }
}
