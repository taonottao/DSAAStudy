package leetcode;

/**
 * 等差数列划分
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/8/27 11:34
 */
public class Exer413 {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int[] dp = new int[n];
        for(int i = 2; i < n; i++){
            dp[i] = nums[i] - nums[i-1] == nums[i-1] - nums[i-2] ? 1 + dp[i-1] : 0;
            sum += dp[i];
        }
        return sum;
    }
}
