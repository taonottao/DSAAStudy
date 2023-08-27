package leetcode;

/**
 * 乘积最大子数组
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/8/27 10:43
 */
public class Exer152 {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] f = new int[n+1];
        int[] g = new int[n+1];
        int max = Integer.MIN_VALUE;
        f[0] = g[0] = 1;
        for(int i = 1; i <= n; i++){
            f[i] = Math.max(nums[i-1], nums[i-1] > 0 ? nums[i-1]*f[i-1] : nums[i-1]*g[i-1]);
            max = Math.max(max, f[i]);
            g[i] = Math.min(nums[i-1], nums[i-1] > 0 ? nums[i-1]*g[i-1] : nums[i-1] * f[i-1]);
        }

        return max;
    }
}
