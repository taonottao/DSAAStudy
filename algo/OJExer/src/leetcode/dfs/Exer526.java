package leetcode.dfs;

/**
 * 优美的排列
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/9/24 10:44
 */
public class Exer526 {
    boolean[] check;
    int ret;
    public int countArrangement(int n) {
        check = new boolean[n+1];
        dfs(1, n);
        return ret;
    }

    private void dfs(int pos, int n){
        if(pos == n + 1){
            ret++;
            return;
        }

        for(int i = 1; i <= n; i++){
            if(check[i] == false && (i % pos == 0 || pos % i == 0)){
                check[i] = true;
                dfs(pos + 1, n);
                check[i] = false;
            }
        }
    }
}
