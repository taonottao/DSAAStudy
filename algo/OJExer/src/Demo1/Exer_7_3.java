package Demo1;

import java.util.Scanner;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/7/9 10:11
 */
public class Exer_7_3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            String result = func(a);
            System.out.println(result);
        }
    }

    /**
     * 因式分解
     * @param num
     * @return
     */
    public static String func(int num){
        String result = "" + num + " = ";
        for(int i = 2; i <= num; i++){
            if( num % i == 0){
                num = num / i;
                result += i + " * ";
                i--;
            }
        }

        result = result.substring(0, result.length() - 2);

        return result;
    }
}
