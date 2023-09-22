package leetcode.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 最长等差数列
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/9/21 9:55
 */
public class Exer1027 {
    public int longestArithSeqLength(int[] nums) {
        Map<Integer, Integer> hash = new HashMap<>();
        hash.put(nums[0], 0);

        int n = nums.length;
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], 2);
        }
        int ret = 2;
        for(int i = 1; i < n; i++){
            for(int j = i + 1; j < n; j++){
                int a = 2 * nums[i] - nums[j];
                if(hash.containsKey(a)){
                    dp[i][j] = dp[hash.get(a)][i] + 1;
                    ret = Math.max(ret, dp[i][j]);
                }
            }
            hash.put(nums[i], i);
        }
        return ret;
    }
}
