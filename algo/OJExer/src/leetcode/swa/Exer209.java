package leetcode.swa;

/**
 * 长度最小的子数组
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/11/12 19:16
 */
public class Exer209 {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        int sum = 0;
        int len = Integer.MAX_VALUE;
        while(right < n){
            sum += nums[right];
            while(sum >= target){
                len = Math.min(len, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }
}
