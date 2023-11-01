package leetcode.prefix_sum;

/**
 * 寻找数组的中心下标
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/10/31 9:28
 */
public class Exer724 {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i-1] + nums[i];
        }
        int ret = -1;
        for (int i = 0; i < n; i++) {
            int sum1 = i - 1 >= 0 ? dp[i-1] : 0;
            int sum2 = i + 1 < n ? dp[n-1] - dp[i] : 0;
            if (sum1 == sum2) {
                ret = i;
                break;
            }
        }
        return ret;
    }
}
