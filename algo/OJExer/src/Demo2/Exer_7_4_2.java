package Demo2;

import java.util.Scanner;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/7/5 15:02
 */
public class Exer_7_4_2 {
    /**
     * 链接：https://www.nowcoder.com/questionTerminal/c0a4b917a15f40a49ca10532ab9019fb
     * 来源：牛客网
     *
     * NowCoder号称自己已经记住了1-100000之间所有的斐波那契数。
     * 为了考验他，我们随便出一个数n，让他说出第n个斐波那契数。当然，斐波那契数会很大。
     * 因此，如果第n个斐波那契数不到6位，则说出该数；否则只说出最后6位
     * @param args
     */
    public static void main(String[] args) {
        long[] ls = new long[10_0000];
        ls[0] = 1;
        ls[1] = 2;
        int border = -1;
        for(int i = 2; i < 10_0000; i++){
            ls[i] = ls[i - 1] + ls[i-2];
            if(ls[i] >= 100_0000){
                ls[i] %= 100_0000;
                if (border == -1) {
                    border = i + 1;
                }
            }

        }
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int n = in.nextInt();
            if (n < border) {
                System.out.printf("%d\n", ls[n-1]);
            }else {
                System.out.printf("%06d\n",ls[n-1]);
            }

        }
    }

}
