package exam;


import java.util.ArrayList;
import java.util.Collections;

public class Demo22 {

    public ArrayList<Integer> removeDuplicatesAndSort(ArrayList<Integer> a, ArrayList<Integer> b) {
        // write code here
        ArrayList<Integer> ret = new ArrayList<>();
        Collections.sort(a);
        Collections.sort(b);
        int i = 0, j = 0;
        while (i < a.size() && j < b.size()) {
            if (a.get(i) < b.get(j)) {
                if (!ret.contains(a.get(i))) {
                    ret.add(a.get(i));
                }
                i++;
            } else {
                if (!ret.contains(b.get(j))) {
                    ret.add(b.get(j));
                }
                j++;
            }
        }
        while (i < a.size()) {
            if (!ret.contains(a.get(i))) {
                ret.add(a.get(i));
            }
            i++;
        }
        while (j < b.size()) {
            if (!ret.contains(b.get(j))) {
                ret.add(b.get(j));
            }
            j++;
        }
        return ret;
    }

    public static void main(String[] args) {
        int ret = crossRiver(2, 5, 0, 0);
        System.out.println(ret);
    }

    public static int crossRiver(int n, int m, int x, int y) {
        // write code here
        int[][] board = new int[n + 1][m + 1];
        init(board, x, y, n, m);
        int[][] dp = new int[n + 2][m + 2];
        dp[0][1] = 1;
        for (int i = 1; i <= n + 1; i++) {
            for (int j = 1; j <= m + 1; j++) {
                if (board[i - 1][j - 1] == 0) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }
        return dp[n + 1][m + 1];
    }

    private static void init(int[][] board, int x, int y, int n, int m) {
        if (x <= n && y <= m)
            board[x][y] = 1;
        if (x - 1 >= 0 && y - 2 >= 0 && x - 1 <= n && y - 2 <= m) {
            board[x - 1][y - 2] = 1;
        }
        if (x - 2 >= 0 && x - 2 <= n && y - 1 >= 0 && y - 1 <= m) {
            board[x - 2][y - 1] = 1;
        }
        if (x + 1 <= n && x + 1 >= 0 && y - 2 >= 0 && y - 2 <= m) {
            board[x + 1][y - 2] = 1;
        }
        if (x + 2 <= n && x + 2 >= 0 && y - 1 >= 0 && y - 1 <= m) {
            board[x + 2][y - 1] = 1;
        }
        if (x - 1 >= 0 && x - 1 <= n && y + 2 <= m && y + 2 >= 0) {
            board[x - 1][y + 2] = 1;
        }
        if (x - 2 >= 0 && x - 2 <= n && y + 1 <= m && y + 1 >= 0) {
            board[x - 2][y + 1] = 1;
        }
        if (x + 2 <= n && x + 2 >= 0 && y + 1 >= 0 && y + 1 <= m) {
            board[x + 2][y + 1] = 1;
        }
        if (x + 1 <= n && x + 1 >= 0 && y + 2 >= 0 && y + 2 <= m) {
            board[x + 1][y + 2] = 1;
        }
    }

}
