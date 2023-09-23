package exam;


import java.util.Scanner;

public class Demo10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int len1 = in.nextInt();
            int k1 = in.nextInt();
            int len2 = in.nextInt();
            int k2 = in.nextInt();
            int num1 = in.nextInt();
            int num2 = in.nextInt();
            char ret = func(num1, k1,len1, num2, k2, len2);
            System.out.println(ret);
        }
    }

    private static char func(int num1, int k1, int len1, int num2, int k2, int len2) {
        long tmp1 = 0;
        long tmp2 = 0;
        String s1 = num1+"";
        String s2 = num1+"";

        for (int i = 0; i < len1; i++) {
            int num = s1.charAt(len1-i-1) - '0';

            tmp1 += Math.pow(k1, i)*num;
        }
        for (int i = 0; i < len2; i++) {
            int num = s2.charAt(len2-i-1) - '0';

            tmp2 += Math.pow(k2, i)*num;
        }
        return tmp1>tmp2?'>':'<';
    }


}
