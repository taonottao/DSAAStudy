package leetcode.prefix_sum;

import java.util.HashMap;

/**
 * 和为 K 的子数组
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/11/1 10:45
 */
public class Exer560 {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        hash.put(0, 1);
        int sum = 0;
        int ret = 0;

        for(int i : nums){
            sum += i;
            ret += hash.getOrDefault(sum - k, 0);
            hash.put(sum, hash.getOrDefault(sum, 0) + 1);
        }
        return ret;
    }
}
