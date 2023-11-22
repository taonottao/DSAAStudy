package leetcode.swa;

/**
 * 最大连续1的个数 III
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/11/19 10:58
 */
public class Exer1004 {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int l = 0;
        int r = 0;
        int zero = 0;
        int ret = 0;
        while(r < n){
            if(nums[r] == 0){
                zero++;
            }
            while(zero > k){
                if(nums[l] == 0){
                    zero--;
                }
                l++;
            }
            ret = Math.max(ret, r - l + 1);
            r++;
        }
        return ret;
    }
}
