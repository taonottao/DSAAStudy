package leetcode.dp;

/**
 * 乘积为正数的最长子数组长度
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/8/27 10:44
 */
public class Exer1567 {
    public int getMaxLen(int[] nums) {
        int n = nums.length;
        int[] f = new int[n+1];
        int[] g = new int[n+1];

        int maxLen = 0;
        for(int i = 1; i <= n; i++){
            if(nums[i-1] > 0){
                f[i] = f[i-1] + 1;
                g[i] = g[i-1] == 0 ? 0 : 1 + g[i-1];
            }else if(nums[i-1] == 0){
                f[i] = g[i] = 0;
            }  else{
                f[i] = g[i-1] == 0 ? 0 : 1 + g[i-1];
                g[i] = f[i-1] + 1;
            }

            maxLen = Math.max(maxLen, f[i]);
        }

        return maxLen;
    }
}
