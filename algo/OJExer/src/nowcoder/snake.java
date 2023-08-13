package nowcoder;

import java.util.Scanner;

/**
 * 蛇形矩阵
 * https://www.nowcoder.com/practice/f228a074c5274619b26be544962375e1?tpId=290&tqId=39922&ru=/exam/oj
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/8/9 20:53
 */
public class snake {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n =sc.nextInt();
        int[][] array= new int[n][n];
        int count = 1;
        for (int i=0;i<2*n-2;i++) {
            for (int j=0;j<=i;j++) {
                int x=i-j;
                if (x<n&&j<n) {
                    if(i%2==0) {
                        array[x][j]=count;
                    } else{
                        array[j][x]=count;
                    }
                    count++;
                }
            }
        }
        array[n-1][n-1]=count;
        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
    }
}
