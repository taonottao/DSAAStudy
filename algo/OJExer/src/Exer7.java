import java.util.Scanner;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/6/11 8:58
 */
public class Exer7 {
    /*
    输入m n 两个整数代表行和列, 输出从左上角到右下角的所有路径数, 只能往下或往右走
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            System.out.println(med(m, n));
        }
    }

    public static int med(int m, int n){
        if((m == 1 && n >= 1) || (m >= 1 && n == 1)){
            return m + n;
        }

        return med(m - 1, n) + med(m, n - 1);
    }
}
