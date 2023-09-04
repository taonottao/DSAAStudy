package leetcode.dfs;

/**
 * Pow(x, n)
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/9/3 10:01
 */
public class Exer50 {
    public double myPow(double x, int n) {
        return n < 0? 1.0 / pow(x, -n) : pow(x, n);
    }
    public double pow(double x, int n) {
        if(n == 0) return 1.0;
        double res = pow(x, n/2);
        double tmp = res * res;
        return n % 2 == 0? tmp : tmp * x;
    }
    public static void main(String[] args) {
        System.out.println(Math.pow(2, 10));
    }
}
