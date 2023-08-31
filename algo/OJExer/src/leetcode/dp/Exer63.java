package leetcode.dp;

/**
 * 不同路径 II
 * dp
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/8/14 10:51
 */
public class Exer63 {
    public int uniquePathsWithObstacles(int[][] ob) {
        int m = ob.length;
        int n = ob[0].length;
        int[][] dp = new int[m+1][n+1];
        dp[0][1] = 1;
        for(int i = 1; i <= m; i++){
            for(int j = 1; j<= n; j++){
                if(ob[i-1][j-1] == 0){
                    dp[i][j] = dp[i][j-1] + dp[i-1][j];
                }
            }
        }
        return dp[m][n];
    }
}
