package leetcode;

/**
 * 环形子数组的最大和
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/8/26 12:44
 */
public class Exer918 {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int[] dp1 = new int[n + 1];
        int[] dp2 = new int[n + 1];
        int sum = 0;
        int max = -0x3f3f3f;
        int min = 0x3f3f3f;
        for(int i = 1; i <= n; i++){
            dp1[i] = Math.max(nums[i-1], nums[i-1] + dp1[i-1]);
            max = Math.max(max, dp1[i]);
            sum += nums[i-1];
            dp2[i] = Math.min(nums[i-1], nums[i-1] + dp2[i-1]);
            min = Math.min(min, dp2[i]);
        }
        int max2 = 0;
        if(min != sum){
            max2 = sum - min;
        }else{
            max2 = -0x3f3f3f;
        }

        return Math.max(max, max2);
    }
}
