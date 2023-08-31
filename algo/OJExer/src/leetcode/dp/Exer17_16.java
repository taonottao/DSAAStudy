package leetcode.dp;

/**
 * 按摩师
 * https://leetcode.cn/problems/the-masseuse-lcci/
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/8/17 9:53
 */
public class Exer17_16 {
    public int massage(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        int[] f = new int[n];
        int[] g = new int[n];
        f[0] = nums[0];
        g[0] = 0;
        for(int i = 1; i < n; i++){
            f[i] = g[i-1] + nums[i];
            g[i] = Math.max(f[i-1], g[i-1]);
        }
        return Math.max(f[n-1], g[n-1]);
    }
}
