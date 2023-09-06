package leetcode.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长定差子序列
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/9/5 9:30
 */
public class Exer1218 {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> hash = new HashMap<>();
        int max = 1;
        for(int a : arr){
            hash.put(a, hash.getOrDefault(a - difference, 0) + 1);
            max = Math.max(max, hash.get(a));
        }
        return max;
    }
}
