package leetcode.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 *
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/10/25 8:55
 */
public class Exer15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            int a = nums[i];
            if (a > 0) {
                break;
            }
            while (left < right) {
                if (left < right && nums[left] + nums[right] > -a) {
                    right--;
                } else if (left < right && nums[left] + nums[right] < -a) {
                    left++;
                } else {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(a);
                    tmp.add(nums[left]);
                    tmp.add(nums[right]);
                    ret.add(tmp);
                    int b = nums[left];
                    int c = nums[right];
                    while (left < right && nums[left] == b) {
                        left++;
                    }
                    while (left < right && nums[right] == c) {
                        right--;
                    }
                }
            }

            while (i < nums.length && nums[i] == a) {
                i++;
            }
            i--;
        }
        return ret;
    }
}
