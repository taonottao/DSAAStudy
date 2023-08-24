package leetcode;

/**
 * 删除并获得点数
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/8/23 10:33
 */
public class Exer740 {
    public int deleteAndEarn(int[] nums) {
        int n = 10001;
        int[] arr = new int[n];
        for(int i : nums){
            arr[i] += i;
        }
        int[] f = new int[n];
        int[] g = new int[n];
        f[0] = arr[0];
        for(int i = 1; i < n; i++){
            f[i] = g[i-1] + arr[i];
            g[i] = Math.max(f[i-1], g[i-1]);
        }
        return Math.max(f[n-1], g[n-1]);
    }
}
