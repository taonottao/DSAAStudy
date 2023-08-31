package leetcode.dp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 单词拆分
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/8/30 9:20
 */
public class Exer139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        // 优化一，将 字典里面的单词存在哈希表里
        Set<String> hash = new HashSet<>(wordDict);

        boolean[] dp = new boolean[n+1];
        s = " " + s;
        dp[0] = true;

        for(int i = 1; i <= n; i++){
            for(int j = i; j >= 1; j--){
                if(dp[j-1] && hash.contains(s.substring(j, i + 1))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
