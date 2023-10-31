package nowcoder.prefix_sum;

import java.util.Scanner;

/**
 * 【模板】前缀和
 * 前缀和可以快速求出数组中某一个连续区间的和
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/10/30 9:53
 */
public class DP34 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int q = in.nextInt();
            int[] arr = new int[n+1];
            for(int i = 1; i <= n; i++){
                arr[i] = in.nextInt();
            }
            long[] dp = new long[n+1];
            for(int i = 1; i <= n; i++){
                dp[i] = dp[i-1] + arr[i];
            }
            for(int i = 0; i < q; i++){
                int l = in.nextInt();
                int r = in.nextInt();
                System.out.println(dp[r] - dp[l-1]);
            }
        }
    }
}
