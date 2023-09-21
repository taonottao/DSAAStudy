package leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/9/20 9:53
 */
public class Exer22 {
    int left, right, n;
    StringBuilder path;
    List<String> ret;
    public List<String> generateParenthesis(int _n) {
        n = _n;
        path = new StringBuilder();
        ret = new ArrayList<>();
        dfs();
        return ret;
    }

    public void dfs(){
        if(right == n){
            ret.add(path.toString());
            return;
        }
        if(left < n){
            path.append('(');
            left++;
            dfs();
            path.deleteCharAt(path.length()-1);
            left--;
        }
        if(right < left){
            path.append(')');
            right++;
            dfs();
            path.deleteCharAt(path.length()-1);
            right--;
        }
    }
}
