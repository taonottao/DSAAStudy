package Demo3;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/8/3 9:19
 */
public class Exer1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int t = in.nextInt();
            for(int i = 0; i < t; i++){
                int n = in.nextInt();
                int k = in.nextInt();
                int[] arr = new int[2*n];
                int j = 0;
                while(j < 2*n){
                    arr[j] = in.nextInt();
                    j++;
                }
                for(int a = 0; a < k; a++){
                    func(arr);
                }
                for(j = 0; j < 2*n; j++){
                    System.out.print(arr[j] + " ");
                }
                System.out.println();
            }
        }
    }
    public static void func(int[] a){
        int i = a.length - 1;
        int m = a.length / 2;
        Deque<Integer> stack = new LinkedList<>();
        while(i-m >= 0){
            stack.push(a[i]);
            stack.push(a[i-m]);
            i--;
        }
        i = 0;
        while(!stack.isEmpty()){
            a[i] = stack.pop();
            i++;
        }
    }
}
