package leetcode.dp;

/**
 * 最长重复子数组
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/10/5 10:51
 */
public class Exer718 {
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int[][] dp = new int[m+1][n+1];

        int maxLen = 0;
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n ;j++){
                if(nums1[i-1] == nums2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }
        return maxLen;
    }
}
