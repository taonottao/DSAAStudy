package leetcode.twopointer;

/**
 * 和为 s 的两个数字
 * 输入一个递增排序的数组和一个数字 s
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/10/20 10:46
 */
public class Exer_JZ_57 {
    public int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            if (nums[l] + nums[r] > target) {
                r--;
            } else if (nums[l] + nums[r] < target) {
                l++;
            } else {
                break;
            }
        }
        ret[0] = nums[l];
        ret[1] = nums[r];
        return ret;
    }
}
