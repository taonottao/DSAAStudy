package leetcode.swa;

import java.util.HashMap;

/**
 * 将 x 减到 0 的最小操作数
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/11/20 8:05
 */
public class Exer1658 {

    // 滑动窗口解法
    public int minOperations(int[] nums, int x) {
        int l = 0;
        int r = 0;
        int ret = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int tmp = 0;
        int target = sum - x;
        if(target < 0) return -1;
        while (r < nums.length) {
            tmp += nums[r];
            while (tmp > target) {
                // if(l < nums.length)
                tmp -= nums[l++];
            }
            if (tmp == target) {
                ret = Math.min(ret, nums.length - r + l - 1);
            }
            r++;
        }

        return ret == Integer.MAX_VALUE ? -1 : ret;
    }

    // 前缀和解法
    public int minOperations1(int[] nums, int x) {
        int n = nums.length;

        int sum = 0;
        int ret = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        HashMap<Integer, Integer> hash = new HashMap<>();
        hash.put(0, -1);
        // sum - x   tmp
        int tmp = 0;
        for (int i = 0; i < n; i++) {
            tmp += nums[i];
            hash.put(tmp, i);
            if (hash.containsKey(tmp - sum + x)) {
                ret = Math.min(ret, n - i + hash.get(tmp - sum + x));
            }
        }

        return ret == Integer.MAX_VALUE ? -1 : ret;
    }
}
