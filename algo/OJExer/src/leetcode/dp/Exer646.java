package leetcode.dp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 最长数对链
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/9/5 8:49
 */
public class Exer646 {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue((o1, o2) -> (int)o1 - (int)o2);
        int[][] arr = {{1,2},{3,4}};
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return 0;
            }
        });
    }
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        int[] dp = new int[n];
        for(int i = 0; i < n; i++){
            dp[i] = 1;
        }
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        int max = 1;
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(pairs[j][1] < pairs[i][0]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(dp[i], max);
        }

        return max;
    }
}
