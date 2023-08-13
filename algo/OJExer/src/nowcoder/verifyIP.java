package nowcoder;

import java.util.List;
import java.util.Scanner;

/**
 * 验证 IP 地址
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/8/10 10:31
 */
public class verifyIP {
    public static void main1(String[] args) {
        String s = "acb::af";
        String[] split = s.split(":");

        System.out.println(split.length);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            int count = 0;
            for (int i = m; i <= n; i++) {
                if (func(i)) {
                    count++;
                    System.out.print(i + " ");
                }
            }
            if (count == 0) {
                System.out.print("no");
            }
            System.out.println();
        }
    }

    public static boolean func(int num) {
        int a = num % 10;
        int b = num / 10 % 10;
        int c = num / 100 % 10;
        if (a * a * a + b * b * b + c * c * c == num) {
            return true;
        }
        return false;
    }
}
