package leetcode.dp;

/**
 * 最大子数组和
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/8/26 10:40
 */
public class Exer53 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = Integer.MIN_VALUE;
        for(int i = 1; i < n; i++){
            dp[i] = Math.max(nums[i], nums[i] + dp[i-1]);
            max = Math.max(max, dp[i]);
        }
        max = Math.max(dp[0], max);
        return max;
    }
}
