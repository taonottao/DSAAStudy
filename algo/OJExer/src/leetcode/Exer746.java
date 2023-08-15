package leetcode;

/**
 * https://leetcode.cn/problems/min-cost-climbing-stairs/
 * 最小花费爬楼梯
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/8/13 12:26
 */
public class Exer746 {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        for(int i = 2; i <= n; i++){
            dp[i] = Math.min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2]);
        }

        return dp[n];
    }
}
