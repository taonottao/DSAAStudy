package Demo2;

import java.util.Scanner;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/7/28 18:40
 */
public class Exer_7_28_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int[][] arr = func(n);
            int flag = 0;
            for(int i = 0; i <= 2*n-1; i++){
                if(arr[n-1][i] % 2 == 0){
                    flag = 1;
                    System.out.println(i+1);
                    break;
                }
            }
            if(flag == 0){
                System.out.println(-1);
            }
        }
    }

    public static int[][] func(int n){
        int[][] arr = new int[n][];

        for(int i = 0; i < n; i++){
            arr[i] = new int[2*i-1];
            for(int j = 0; j < 2*(i+1) - 1; j++){
                if(j==0 || j == 2*(i+1) - 2){
                    arr[i][j] = 1;
                } else if (j == 1){
                    arr[i][j] = arr[i-1][j] + arr[i-1][j+1];
                } else if(j == 2*(i+1) -3){
                    arr[i][j] = arr[i-1][j] + arr[i-1][j-1];
                } else {
                    arr[i][j] = arr[i-1][j-1] + arr[i-1][j] + arr[i-1][j+1];
                }
            }
        }

        return arr;
    }
}
