package Demo2;

import java.util.Scanner;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/7/22 18:55
 */
public class Exer_7_5_2 {
    /**
     * 客似云来
     */
    public static void main(String[] args) {
        long[] arr = new long[80];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < 80; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int from = in.nextInt();
            int to = in.nextInt();
            long sum = 0;
            for (int i = from-1; i <= to-1; i++) {
                sum += arr[i];
            }
            System.out.println(sum);
        }
    }

}
