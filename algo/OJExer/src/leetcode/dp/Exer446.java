package leetcode.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 等差数列划分 II - 子序列
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/9/22 10:56
 */
public class Exer446 {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        Map<Long, List<Integer>> hash = new HashMap<>();
        for(int i = 0; i < n; i++){
            long tmp = (long)nums[i];
            if(!hash.containsKey(tmp)){
                hash.put(tmp, new ArrayList<Integer>());
            }
            hash.get(tmp).add(i);
        }
        int[][] dp = new int[n][n];
        int sum = 0;
        for(int j = 2; j < n; j++){
            for(int i = 1; i < j; i++){
                long a = 2L * nums[i] - nums[j];
                if(hash.containsKey(a)){
                    for(int k : hash.get(a)){
                        if(k < i){
                            dp[i][j] += dp[k][i] + 1;
                        }
                    }
                }
                sum += dp[i][j];
            }
        }
        return sum;
    }
}
