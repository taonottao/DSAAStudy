package nowcoder;

/**
 * 把数字翻译成字符串
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/8/28 8:43
 */
public class BM69 {
    public int solve (String nums) {
        // write code here
        char[] ch = nums.toCharArray();
        int n = nums.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        if(ch[1-1] != '0') dp[1] = 1;

        for(int i = 2; i <= n; i++){
            if(ch[i-1] != '0'){
                dp[i] += dp[i-1];
            }
            int x = (ch[i-2] - '0') * 10 + ch[i-1] - '0';
            if(x >= 10 && x <= 26){
                dp[i] += dp[i-2];
            }

        }

        return dp[n];
    }
}
