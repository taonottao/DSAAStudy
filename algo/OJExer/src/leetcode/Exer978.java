package leetcode;

/**
 * 最长湍流子数组
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/8/28 12:26
 */
public class Exer978 {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        int[] f = new int[n];
        int[] g = new int[n];

        for(int i = 0; i < n; i++){
            f[i] = g[i] = 1;
        }
        int max = 1;
        for(int i = 1; i < n; i++){
            if(arr[i-1] < arr[i]){
                f[i] = g[i-1] + 1;
            } else if(arr[i-1] > arr[i]){
                g[i] = f[i-1] + 1;
            }
            max = Math.max(max, Math.max(f[i], g[i]));
        }

        return max;
    }
}
