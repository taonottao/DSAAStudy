package leetcode.dp;

/**
 * 摆动序列
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/9/3 11:00
 */
public class Exer376 {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        int[] f = new int[n];
        int[] g = new int[n];

        for(int i = 0; i < n; i++){
            f[i] = g[i] = 1;
        }
        int max = 1;
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] < nums[j]){
                    g[i] = Math.max(g[i], f[j] + 1);
                }else if(nums[i] > nums[j]){
                    f[i] = Math.max(f[i], g[j] + 1);
                }
            }
            max = Math.max(f[i], g[i]);
        }
        return max;
    }
}
