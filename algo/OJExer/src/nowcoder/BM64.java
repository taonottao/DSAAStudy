package nowcoder;

/**
 * https://www.nowcoder.com/practice/6fe0302a058a4e4a834ee44af88435c7?tpId=295&tqId=2366451&ru=/exam/oj&qru=/ta/format-top101/question-ranking&sourceUrl=%2Fexam%2Foj
 * 最小花费爬楼梯
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/8/13 13:58
 */
public class BM64 {
    public int minCostClimbingStairs (int[] cost) {
        // write code here
        int n = cost.length;
        int[] dp = new int[n];
        dp[n-1] = cost[n-1];
        dp[n-2] = cost[n-2];
        for(int i = n -3; i >= 0; i--){
            dp[i] = Math.min(dp[i+1] + cost[i], dp[i+2] + cost[i]);
        }

        return Math.min(dp[0], dp[1]);
    }
}
