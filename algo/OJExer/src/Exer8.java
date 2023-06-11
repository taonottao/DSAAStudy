/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/6/11 9:11
 */
public class Exer8 {
    /*
    另类加法
    不使用 + 或其他算术运算符, 实现两数相加
     */
    public static void main(String[] args) {
        System.out.println(add(2, 3));
    }

    public static int add(int a, int b){
        if(b == 0){
            return a;
        }
        int sum = 0;
        int carray = 0;
        while (b != 0){
            sum = a ^ b;
            carray = (a & b) << 1;
            a = sum;
            b = carray;
        }
        return sum;
    }
}
