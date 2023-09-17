package exam;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Demo8 {

    public int calculate(int m, int n, int[] scores) {
        // write code here
        int maxNum = 2 * n;
        int minNum = 2 * m;
        if (scores.length < minNum || scores.length > maxNum) {
            return -1;
        }

        Arrays.sort(scores);
        int index = scores.length - 1 - n;
        return scores[index];
    }

    public static int maximumScore(int[] nums, int k) {
        // write code here
        if (nums.length == 0) {
            return 0;
        }
        int left = Integer.MIN_VALUE;
        int right = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            left = Math.max(nums[i] - k, left);
            right = Math.max(nums[i] + k, right);
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int min = nums[i] - k;
            int max = nums[i] + k;
            if (min > right || max < left) {
                continue;
            }
            count++;
        }
        return count > 1 ? count : 1;
    }

    public static void main1(String[] args) {
        int[] nums = {4,6,1,2};
        int k = 2;
        int ret = maximumScore(nums, k);
        System.out.println(ret);
    }

    public static void main(String[] args) {
        String s1= "AABBCC";
        String s2 = "ACC";
        int res = subsequence(s1, s2);
        System.out.println(res);
    }

    public static int subsequence (String source, String pattern) {
        // write code here
        if (source.length() < pattern.length()) {
            return 0;
        }
        HashMap<Character, Integer> hash1 = new HashMap<>();
        HashMap<Character, Integer> hash2 = new HashMap<>();
        int n = source.length();
        for (int i = 0; i < n; i++) {
            char ch1 = source.charAt(i);
            if (!hash1.containsKey(ch1) && ch1 >= 'A' && ch1 <= 'E') {
                hash1.put(ch1,1);
            }else {
                hash1.put(ch1, hash1.get(ch1) + 1);
            }
            if (i < pattern.length()) {
                char ch2 = pattern.charAt(i);
                if (!hash2.containsKey(ch2) && ch2 >= 'A' && ch2 <= 'E') {
                    hash2.put(ch2,1);
                }else {
                    hash2.put(ch2, hash2.get(ch2) + 1);
                }
            }
        }
        int count = 1;

        for (Map.Entry<Character, Integer> entry : hash2.entrySet()) {
            if (!hash1.containsKey(entry.getKey()) || hash1.get(entry.getKey()) < entry.getValue()) {
                count = 0;
                break;
            } else {
                int tmp = hash1.get(entry.getKey());
                int tmp2 = entry.getValue();
                int n1 = tmp;
                int n2 = tmp2;
                for (int i = 1; i < tmp2; i++) {
                    n1 *= --tmp;
                    n2 *= --tmp2;
                }
                hash1.put(entry.getKey(), n1/n2);
                count *= hash1.get(entry.getKey());
            }
        }
        if (count != 0) {

        }
        return count;
    }

}
