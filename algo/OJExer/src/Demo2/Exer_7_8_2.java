package Demo2;

import org.junit.Test;

import java.util.Scanner;

/**
 * Rational Arithmetic
 *
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/7/30 9:41
 */
public class Exer_7_8_2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String str1 = in.next();
            String str2 = in.next();
            long a1 = Long.parseLong(str1.split("/")[0]);
            long b1 = Long.parseLong(str1.split("/")[1]);
            long a2 = Long.parseLong(str2.split("/")[0]);
            long b2 = Long.parseLong(str2.split("/")[1]);

            System.out.println(sum(a1, b1, a2, b2));
            System.out.println(sub(a1, b1, a2, b2));
            System.out.println(mul(a1, b1, a2, b2));
            System.out.println(div(a1, b1, a2, b2));
        }
    }

    public static boolean isZero(long a) {
        if (a == 0) {
            return true;
        }
        return false;
    }

    public static boolean isPositive(long a) {
        if (a > 0) {
            return true;
        }
        return false;
    }

    public static String finalNum(long a, long b) {
        if (a == 0) {
            return "0";
        }
        long integer = a / b;
        StringBuilder sb = new StringBuilder();
        if (integer != 0) {
            if ((isPositive(a) && isPositive(b))) {
                sb.append(integer);
                long maxNum = maxNum(a, b);
                if (maxNum != b) {
                    sb.append(" ");
                    sb.append((a - b * integer) / maxNum);
                    sb.append("/");
                    sb.append(b / maxNum);
                }
            } else if ((!isPositive(a) && isPositive(b))) {
                sb.append("(");
                sb.append(integer);
                long maxNum = maxNum(-a, b);
                if (maxNum != b) {
                    sb.append(" ");
                    sb.append(-(a + b * (-integer)) / maxNum);
                    sb.append("/");
                    sb.append(b / maxNum);
                }
                sb.append(")");
            } else if ((isPositive(a) && !isPositive(b))) {
                sb.append("(");
                sb.append(integer);
                long maxNum = maxNum(a, -b);
                if (maxNum != -b) {
                    sb.append(" ");
                    sb.append((a - b * integer) / maxNum);
                    sb.append("/");
                    sb.append(-b / maxNum);
                }
                sb.append(")");
            } else if ((!isPositive(a) && !isPositive(b))) {
                sb.append(integer);
                long maxNum = maxNum(-a, -b);
                if (maxNum != -b) {
                    sb.append(" ");
                    sb.append((-a + b * integer) / maxNum);
                    sb.append("/");
                    sb.append(-b / maxNum);
                }
            }
        } else {
            if ((isPositive(a) && isPositive(b))) {
                long maxNum = maxNum(a, b);
                if (maxNum != b) {
                    sb.append(a / maxNum);
                    sb.append("/");
                    sb.append(b / maxNum);
                }
            } else if ((!isPositive(a) && isPositive(b))) {
                sb.append("(");
                long maxNum = maxNum(-a, b);
                if (maxNum != b) {
                    sb.append(a / maxNum);
                    sb.append("/");
                    sb.append(b / maxNum);
                }
                sb.append(")");
            } else if ((isPositive(a) && !isPositive(b))) {
                sb.append("(");
                long maxNum = maxNum(a, -b);
                if (maxNum != -b) {
                    sb.append(-(a ) / maxNum);
                    sb.append("/");
                    sb.append(-b / maxNum);
                }
                sb.append(")");
            } else if ((!isPositive(a) && !isPositive(b))) {
                long maxNum = maxNum(-a, -b);
                if (maxNum != -b) {
                    sb.append((-a ) / maxNum);
                    sb.append("/");
                    sb.append(-b / maxNum);
                }
            }
        }
        return sb.toString();
    }

    /**
     * 最大公约数
     *
     * @return
     */
    public static long maxNum(long a, long b) {
        while (b != 0) {
            long tmp = a;
            a = b;
            b = tmp % b;
        }
        return a;
    }

    public static String sum(long a1, long b1, long a2, long b2) {
        if (isZero(a2)) {
            return finalNum(a1, b1) + " + " + finalNum(a2, b2) + " = " + finalNum(a1, b1);
        } else {
            long newA1 = a1 * b2;
            long newB = b1 * b2;
            long newA2 = a2 * b1;
            return finalNum(a1, b1) + " + " + finalNum(a2, b2) + " = " + finalNum(newA1 + newA2, newB);
        }
    }

    public static String sub(long a1, long b1, long a2, long b2) {
        if (isZero(a2)) {
            return finalNum(a1, b1) + " - " + finalNum(a2, b2) + " = " + finalNum(a1, b1);
        } else {
            long newA1 = a1 * b2;
            long newB = b1 * b2;
            long newA2 = a2 * b1;
            return finalNum(a1, b1) + " - " + finalNum(a2, b2) + " = " + finalNum(newA1 - newA2, newB);
        }
    }

    public static String mul(long a1, long b1, long a2, long b2) {
        if (isZero(a2)) {
            return finalNum(a1, b1) + " * " + finalNum(a2, b2) + " = " + 0;
        } else {
            long newA = a1 * a2;
            long newB = b1 * b2;
            return finalNum(a1, b1) + " * " + finalNum(a2, b2) + " = " + finalNum(newA, newB);
        }
    }

    public static String div(long a1, long b1, long a2, long b2) {
        if (isZero(a2)) {
            return finalNum(a1, b1) + " / " + finalNum(a2, b2) + " = " + "Inf";
        } else {
            long newA = a1 * b2;
            long newB = b1 * a2;
            return finalNum(a1, b1) + " / " + finalNum(a2, b2) + " = " + finalNum(newA, newB);
        }
    }

    @Test
    public void test() {
        String str = finalNum(4, -12);
//        String str = sum(5,3,0,6);
//        String str = sub(5,3,0,6);
//        String str = mul(5,3,0,6);
//        String str = div(5,3,0,6);

        System.out.println(str);
    }

}
