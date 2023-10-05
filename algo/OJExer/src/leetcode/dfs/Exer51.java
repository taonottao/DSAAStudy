package leetcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * N 皇后
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/10/4 15:19
 */
public class Exer51 {
    boolean[] checkCol, checkDig1, checkDig2;
    List<List<String>> ret;
    char[][] path;
    int n;
    public List<List<String>> solveNQueens(int _n) {
        n = _n;
        checkCol = new boolean[n];
        checkDig1 = new boolean[n*2];
        checkDig2 = new boolean[n*2];
        ret = new ArrayList<>();
        path = new char[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(path[i], '.');
        }

        dfs(0);
        return ret;
    }

    private void dfs(int row){
        if(row == n){
            List<String> tmp = new ArrayList<>();
            for(int i = 0; i < n; i++){
                tmp.add(new String(path[i]));
            }
            ret.add(new ArrayList<>(tmp));
        }

        for(int col = 0; col < n; col++){
            if(checkCol[col] == false && checkDig1[row-col+n] == false && checkDig2[row+col] == false){
                path[row][col] = 'Q';
                checkCol[col] = checkDig1[row-col+n] = checkDig2[row+col] = true;
                dfs(row+1);
                path[row][col] = '.';
                checkCol[col] = checkDig1[row-col+n] = checkDig2[row+col] = false;
            }
        }
    }
}
