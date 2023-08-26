package leetcode;

/**
 * 买卖股票的最佳时机含手续费
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/8/25 10:30
 */
public class Exer714 {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][1] = -prices[0];
        for(int i = 1; i < n; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i-1][0] - prices[i], dp[i-1][1]);
        }
        return dp[n-1][0];
    }
}
