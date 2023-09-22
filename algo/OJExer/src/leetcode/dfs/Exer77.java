package leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/9/21 8:57
 */
public class Exer77 {
    List<List<Integer>> ret;
    List<Integer> path;
    int n,k;
    public List<List<Integer>> combine(int _n, int _k) {
        ret = new ArrayList<>();
        path = new ArrayList<>();
        n = _n;
        k = _k;
        dfs(1);
        return ret;
    }

    private void dfs(int start){
        if(path.size() == k){
            ret.add(new ArrayList(path));
        }
        for(int i = start; i <= n; i++){
            path.add(i);
            dfs(i+1);
            path.remove(path.size()-1);
        }
    }
}
