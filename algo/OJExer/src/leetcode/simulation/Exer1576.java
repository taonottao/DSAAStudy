package leetcode.simulation;

/**
 * 替换所有的问号
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/11/26 10:40
 */
public class Exer1576 {
    public String modifyString(String ss) {
        char[] s = ss.toCharArray();
        int n = s.length;

        for(int i = 0; i < n; i++){
            if(s[i] == '?'){
                for(char ch = 'a'; ch <= 'z'; ch++){
                    if((i == 0 || ch != s[i-1]) && (i == n - 1 || s[i+1] != ch)){
                        s[i] = ch;
                        break;
                    }
                }
            }
        }
        return String.valueOf(s);
    }
}
