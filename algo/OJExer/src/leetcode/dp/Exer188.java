package leetcode.dp;

/**
 *  买卖股票的最佳时机 IV
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/8/25 12:21
 */
public class Exer188 {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int INF = 0x3f3f3f;
        k = Math.min(k, n/2);
        int[][] f = new int[n][k+1];
        int[][] g = new int[n][k+1];
        for(int i = 0; i <= k; i++){
            f[0][i] = g[0][i] = -INF;
        }
        f[0][0] = -prices[0];
        g[0][0] = 0;
        for(int i = 1; i < n; i++){
            for(int j = 0; j <= k; j++){
                f[i][j] = Math.max(f[i-1][j], g[i-1][j] - prices[i]);
                g[i][j] = g[i-1][j];
                if(j >= 1){
                    g[i][j] = Math.max(g[i][j], f[i-1][j-1] + prices[i]);
                }
            }
        }
        int res = 0;
        for(int i = 0; i <= k; i++){
            res = Math.max(res, g[n-1][i]);
        }
        return res;
    }
}
