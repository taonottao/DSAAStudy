import java.util.Scanner;
import java.util.concurrent.ExecutorService;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/6/12 16:49
 */
public class Exer10 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int count = getCount(n);
            System.out.println(count);
        }

    }
    /*
    求一个byte数字对应的二进制数字中1的最大连续数,
    例如3的二进制为00000011, 最大连续数为2个1
     */
    public static int getCount(int n){
        int count = 0;
        int modCount = 0;
        while(n !=  0){
            if((n & 1) == 1){
                count++;
                modCount = Math.max(count, modCount);
            } else {
                count = 0;
            }
            n =  n >> 1;
        }
        return modCount;
    }

}
