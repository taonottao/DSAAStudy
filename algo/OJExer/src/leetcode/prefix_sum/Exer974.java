package leetcode.prefix_sum;

import java.util.HashMap;

/**
 * 和可被 K 整除的子数组(某年蓝桥杯真题)
 *
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/11/5 9:26
 */
public class Exer974 {

    public static void main(String[] args) {
        System.out.println(((-5) % 3 + 3) % 3);
    }

    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        hash.put(0 % k, 1);

        int sum = 0;
        int ret = 0;

        for (int i : nums) {
            sum += i;
            int r = (sum % k + k) % k;
            ret += hash.getOrDefault(r, 0);
            hash.put(r, hash.getOrDefault(r, 0) + 1);
        }

        return ret;
    }
}
