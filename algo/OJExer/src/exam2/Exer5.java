package exam2;

import java.util.ArrayList;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/11/3 18:57
 */
public class Exer5 {
    public int findLongestSubArray(ArrayList<Integer> nums) {
        // write code here
        int n = nums.size();
        int[] f = new int[n];
        int[] g = new int[n];

        if (nums.get(0) > 0) {
            f[0] = 1;
        } else if (nums.get(0) < 0) {
            g[0] = 1;
        }

        int ret = 0;
        for (int i = 1; i < n; i++) {
            if (nums.get(i) == 0) {
                f[i] = g[i] = 0;
            } else if (nums.get(i) > 0) {
                f[i] = f[i - 1] + 1;
                g[i] = g[i - 1] == 0 ? 0 : g[i - 1] + 1;
                ret = Math.max(ret, f[i]);
            } else {
                f[i] = g[i - 1] == 0 ? 0 : g[i - 1] + 1;
                g[i] = f[i - 1] + 1;
                ret = Math.max(ret, f[i]);
            }
        }

        return ret;
    }

    public Boolean palindromeNumber(int number) {

        //write your code here......
        String str = String.valueOf(number);
        for (int i = 0; i < 2; i++) {
            if (str.charAt(i) != str.charAt(5 - i - 1)) {
                return false;
            }
        }

        return true;

    }
}
