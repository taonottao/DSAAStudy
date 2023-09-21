package leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 电话号码的字母组合
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/9/20 8:59
 */
public class Exer17 {
    String[] hash = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> ret;
    StringBuilder path;
    public List<String> letterCombinations(String digits) {
        ret = new ArrayList<>();
        path = new StringBuilder();
        if("".equals(digits)){
            return ret;
        }
        dfs(digits, 0);
        return ret;
    }

    private void dfs(String digits, int pos){
        if(pos == digits.length()){
            ret.add(path.toString());
            return;
        }
        String cur = hash[digits.charAt(pos)-'0'];
        for(int i = 0; i < cur.length(); i++){
            path.append(cur.charAt(i));
            dfs(digits, pos + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
