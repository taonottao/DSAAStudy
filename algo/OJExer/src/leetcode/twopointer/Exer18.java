package leetcode.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四数之和
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/10/29 10:12
 */
public class Exer18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3;) {
            long a = (long)nums[i];
            if (a > 0 && a > target) {
                break;
            }
            for (int j = i + 1; j < nums.length - 2;) {
                long b = (long)nums[j];
                if (b > 0 && b > target - a) {
                    break;
                }
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    if (nums[left] + nums[right] > target - a - b) {
                        right--;
                    } else if (nums[left] + nums[right] < target - a - b) {
                        left++;
                    } else {
                        int c = nums[left];
                        int d = nums[right];
                        ret.add(Arrays.asList((int)a, (int)b, c, d));
                        while (left < right && nums[left] == c) {
                            left++;
                        }
                        while (left < right && nums[right] == d) {
                            right--;
                        }
                    }
                }
                j++;
                while (j < nums.length - 2 && nums[j] == b) {
                    j++;
                }
            }
            i++;
            while (i < nums.length - 3 && nums[i] == a) {
                i++;
            }
        }
        return ret;
    }
}
