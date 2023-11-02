package leetcode.prefix_sum;

/**
 * 除自身以外数组的乘积
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/11/1 9:51
 */
public class Exer238 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] f = new int[n];
        int[] g = new int[n];

        f[0] = g[n-1] = 1;
        for(int i = 1; i < n; i++){
            f[i] = f[i-1] * nums[i-1];
        }
        for(int j = n - 2; j >= 0; j--){
            g[j] = g[j+1] * nums[j+1];
        }
        int[] ret = new int[n];
        for(int i = 0; i < n; i++){
            ret[i] = f[i] * g[i];
        }
        return ret;
    }
}
