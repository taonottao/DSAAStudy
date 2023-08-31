package leetcode.dp;

/**
 * 买卖股票的最佳时机 III
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/8/25 11:44
 */
public class Exer123 {
    public int maxProfit(int[] prices) {

        int n = prices.length;
        int INF = 0x3f3f3f;

        int[][] f = new int[n][3];
        int[][] g = new int[n][3];
        for(int i = 0; i < 3; i++){
            f[0][i] = -INF;
            g[0][i] = -INF;
        }
        g[0][0] = 0;
        f[0][0] = - prices[0];
        for(int i = 1; i < n; i++){
            for(int j = 0; j < 3; j++){
                f[i][j] = Math.max(f[i-1][j], g[i-1][j] - prices[i]);
                g[i][j] = g[i-1][j];
                if(j >= 1){
                    g[i][j] = Math.max(g[i][j], f[i-1][j-1] + prices[i]);
                }
            }
        }

        return Math.max(g[n-1][0], Math.max(g[n-1][1], g[n-1][2]));

    }
}
