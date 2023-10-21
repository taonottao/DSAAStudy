package exam2;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Exer1 {
    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int m = in.nextInt();
            int ret = judge(n, m);
            System.out.println(ret);
        }
    }

    private static int judge(int n, int m) {
        return n;
    }

    public static void main2(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int k = in.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            boolean[] tmp = new boolean[n];
            int min = Integer.MAX_VALUE;
            int mIndex = 0;
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
                if (a[i] > k) {
                    tmp[i] = true;
                }
                if (min > a[i]) {
                    min = a[i];
                    mIndex = i;
                }
            }
            int i = 0;
            int flag = 0;
            while (i < mIndex) {
                if(i > 0)
                    b[i] = Math.max(a[i], b[i-1] + 1);
                else
                    b[i] = a[i];
                i++;
                if (b[i] > k) {
                    flag = 1;
                    break;
                }
            }
            b[i] = a[i] + 1;
            i++;
            while (i < n) {
                b[i] = b[i-1] + 1;
                if (b[i] > k) {
                    flag = 1;
                    break;
                }
                i++;
            }
            if (flag == 1) {
                System.out.println(-1);
            } else {
                for (int j = 0; j < n; j++) {
                    System.out.print(b[j] + " ");
                }
                System.out.println();
            }
        }
    }

    public static void main3(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            int m = in.nextInt();
            int n = in.nextInt();
            char[][] chars = new char[m][n];
            for (int i = 0; i < m; i++) {
                String tmp = in.next();
                for (int j = 0; j < n; j++) {
                    chars[i][j] = tmp.charAt(j);
                }
            }
            int ret = func(chars, m, n);
        }
    }

    private static int func(char[][] chars, int m, int n) {
        int max = 0;
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            String a = in.next();
            String b = in.next();
            int l = 0;
            int r = n - 1;
            double count = 1;
            while (l <= r) {
                int tmp = 0;
                if (l == r && a.charAt(l) == b.charAt(r)) {
                    tmp = 1;
                    count = (count % (1e9 + 7)) * tmp;
                    break;
                } else if (l == r && a.charAt(l) != b.charAt(r)) {
                    count = 0;
                    break;
                }
                if (a.charAt(l) == a.charAt(r)) {
                    tmp++;
                }
                if (a.charAt(l) != a.charAt(r) && a.charAt(l) == b.charAt(r)) {
                    tmp++;
                }
                if (b.charAt(l) != a.charAt(l) && b.charAt(l) == a.charAt(r)) {
                    tmp++;
                }
                if (b.charAt(l) != a.charAt(l) && a.charAt(r) != b.charAt(r) && b.charAt(l) == b.charAt(r)) {
                    tmp++;
                }
                count = (count % (1e9 + 7)) * tmp;
                l++;
                r--;
                if (count == 0) {
                    break;
                }
            }
            System.out.println((int)count);
        }
    }
}

