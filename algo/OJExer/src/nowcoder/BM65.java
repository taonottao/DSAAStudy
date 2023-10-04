package nowcoder;

import java.util.Stack;

/**
 * 最长公共子序列(二)
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/10/3 9:34
 */
public class BM65 {
    public String LCS (String ss1, String ss2) {
        // write code here
        int m = ss1.length();
        int n = ss2.length();

        char[] s1 = ss1.toCharArray();
        char[] s2 = ss2.toCharArray();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1[i - 1] == s2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        //从动态规划数组末尾开始
        int i = m, j = n;
        Stack<Character> s = new Stack<Character>();
        while (dp[i][j] != 0) {
            //来自于左方向
            if (dp[i][j] == dp[i - 1][j])
                i--;
                //来自于上方向
            else if (dp[i][j] == dp[i][j - 1])
                j--;
                //来自于左上方向
            else {
                i--;
                j--;
                //只有左上方向才是字符相等的情况，入栈，逆序使用
                s.push(s1[i]);
            }
        }
        StringBuilder res = new StringBuilder();
        //拼接子序列
        while (!s.isEmpty())
            res.append(s.pop());
        //如果两个完全不同，返回字符串为空，则要改成-1
        return !(res.length() == 0) ? res.toString() : "-1";
    }
}
