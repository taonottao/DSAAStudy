package Demo2;

import org.junit.Test;

import java.util.Scanner;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/7/23 19:32
 */
public class Exer_7_7_1 {

    /**
     * 年会抽奖
     * 错排问题 F(n) = (n-1)( F(n-1) + F(n-2) )
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long[] num = new long[21];
        num[0] = 0;
        num[1] = 0;
        num[2] = 1;

        long[] total = new long[21];
        total[0] = 1;
        total[1] = 1;
        total[2] = 2;
        for (int i = 3; i < 21; i++) {
            num[i] = (i-1)*(num[i-1] + num[i-2]);
            total[i] = i*total[i-1];
        }
        while (in.hasNextInt()) {
            int n = in.nextInt();
            double finalNum = 100.0 * num[n] / total[n];
            System.out.printf("%.2f%%\n", finalNum);
        }
    }
}
