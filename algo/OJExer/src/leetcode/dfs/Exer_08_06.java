package leetcode.dfs;

import java.util.List;

/**
 * 汉诺塔问题
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/8/31 17:10
 */
public class Exer_08_06 {
    public void hanota(List<Integer> a, List<Integer> b, List<Integer> c) {
        dfs(a, b, c, a.size());
    }

    public void dfs(List<Integer> a, List<Integer> b, List<Integer> c, int n){
        if(n == 1){
            c.add(a.remove(a.size() - 1));
            return;
        }
        dfs(a, c, b, n - 1);
        c.add(a.remove(a.size() - 1));
        dfs(b, a, c, n - 1);
    }
}
