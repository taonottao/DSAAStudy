package leetcode;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/8/17 10:22
 */
public class Exer213 {
    public int rob(int[] nums) {
        int n = nums.length;
        return Math.max(nums[0] + rob1(nums, 2, n - 2), rob1(nums, 1, n - 1));
    }

    public int rob1(int[] nums, int left, int right){
        if(left > right){
            return 0;
        }
        int n = nums.length;
        int[] f = new int[n];
        int[] g = new int[n];
        f[left] = nums[left];
        for(int i = left + 1; i <= right; i++){
            f[i] = g[i-1] + nums[i];
            g[i] = Math.max(g[i-1], f[i-1]);
        }
        return Math.max(f[right], g[right]);
    }
}
