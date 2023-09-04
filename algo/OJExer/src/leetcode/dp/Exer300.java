package leetcode.dp;

/**
 * 最长递增子序列
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/9/3 10:36
 */
public class Exer300 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for(int i = 0; i < n; i++){
            dp[i] = 1;
        }
        int res = 1;
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i])
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
