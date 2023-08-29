package nowcoder;

/**
 * 买卖股票的最好时机(三)
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/8/28 9:14
 */
public class BM82 {
    public int maxProfit (int[] prices) {
        // write code here
        int INF = 0x3f3f3f;
        int n = prices.length;
        int[][] f = new int[n][3];
        int[][] g = new int[n][3];
        for(int i = 0; i < 3; i++){
            f[0][i] = g[0][i] =  - INF;
        }
        f[0][0] = - prices[0];
        g[0][0] = 0;

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
