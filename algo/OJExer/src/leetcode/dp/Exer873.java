package leetcode.dp;

import java.util.HashMap;

/**
 * 最长的斐波那契子序列的长度
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/9/16 23:50
 */
public class Exer873 {
    public int lenLongestFibSubseq(int[] arr) {

        HashMap<Integer, Integer> hash = new HashMap<>();
        int n = arr.length;
        for(int i = 0; i < n; i++){
            hash.put(arr[i], i);
        }
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j< n; j++){
                dp[i][j] = 2;
            }
        }
        int ret = 2;
        for(int j = 2; j < n; j++){
            for(int i = 1; i < j; i++){
                int a = arr[j] - arr[i];
                if(a < arr[i] && hash.containsKey(a)){
                    dp[i][j] = dp[hash.get(a)][i] + 1;
                }
                ret = Math.max(ret, dp[i][j]);
            }
        }
        return ret >= 3? ret:0;
    }
}
