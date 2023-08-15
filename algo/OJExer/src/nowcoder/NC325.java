package nowcoder;

import java.util.ArrayList;

/**
 * 不同路径的数目(二)
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/8/14 10:53
 */
public class NC325 {
    public static void main(String[] args) {
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add('A');
        }

        ArrayList<ArrayList<Character>> lists = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            lists.add(list);
        }
        int i = uniquePathsWithObstacles(lists);
        System.out.println(i);
    }

    public static int uniquePathsWithObstacles (ArrayList<ArrayList<Character>> ob) {
        // write code here
        int m = ob.size();
        int n = ob.get(0).size();
        long[][] dp = new long[m+1][n+1];
        dp[0][1] = 1;
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(ob.get(i-1).get(j-1) != '0'){
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }

        return (int) dp[m][n];
    }

}
