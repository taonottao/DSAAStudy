package leetcode.swa;

/**
 * 无重复字符的最长子串
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/11/13 10:10
 */
public class Exer3 {
    public int lengthOfLongestSubstring(String ss) {
        char[] s = ss.toCharArray();
        int left = 0, right = 0;
        int n = s.length;
        int ret = 0;
        int[] hash = new int[128];
        while(right < n){
            hash[s[right]]++;
            while(hash[s[right]] > 1){
                hash[s[left]]--;
                left++;
            }
            ret = Math.max(ret, right - left + 1);
            right++;
        }
        return ret;
    }
}
