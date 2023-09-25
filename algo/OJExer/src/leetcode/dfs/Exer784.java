package leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 字母大小写全排列
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/9/24 10:16
 */
public class Exer784 {
    StringBuilder path;
    List<String> ret;
    public List<String> letterCasePermutation(String s) {
        path = new StringBuilder();
        ret = new ArrayList<>();
        dfs(s, 0);
        return ret;
    }

    private void dfs(String s, int pos){
        if(pos == s.length()){
            ret.add(path.toString());
            return;
        }
        char ch = s.charAt(pos);
        path.append(ch);
        dfs(s, pos+1);
        path.deleteCharAt(path.length()-1);

        if(ch < '0' || ch > '9'){
            char tmp = change(ch);
            path.append(tmp);
            dfs(s, pos+1);
            path.deleteCharAt(path.length()-1);
        }
    }

    private char change(char ch){
        if(ch >= 'a' && ch <= 'z'){
            ch -= 32;
        }else{
            ch += 32;
        }
        return ch;
    }
}
