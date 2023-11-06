package leetcode.prefix_sum;

import java.util.HashMap;

/**
 * 连续数组
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/11/5 10:18
 */
public class Exer525 {

    public int findMaxLength(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }

        HashMap<Integer, Integer> hash = new HashMap<>();

        int ret = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i == nums.length - 1) {
                if (sum == 0) {
                    ret = nums.length;
                }
                break;
            }

            ret = Math.max(i - hash.getOrDefault(sum, i), ret);
        }
        return ret;
    }

}
