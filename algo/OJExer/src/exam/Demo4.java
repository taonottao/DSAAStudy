package exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//索引
public class Demo4 {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        // 注意 hasNext 和 hasNextLine 的区别
//        while (in.hasNextInt()) { // 注意 while 处理多个 case
//            int n = in.nextInt();
//
//
//        }
//    }

    public static boolean isPrime(int a, int b) {
        int c = a + b;
        for (int i = 2; i <= Math.sqrt(c); i++) {
            if (c % i == 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int t = in.nextInt();

            for (int i = 0; i < t; i++) {
                int n = in.nextInt();
                int l = in.nextInt();
                int r = in.nextInt();
                List<Integer> list = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    list.add(in.nextInt());
                }
                Collections.sort(list);
                int count = judge(list, l, r);
                System.out.println(count);
            }

        }
    }

    private static int judge(List<Integer> list, int l, int r) {
        int size = list.size();
        int min = list.get(0);
        int max = list.get(size - 1);
        if (min + 1 < l || max - 1 > r) {
            return -1;
        }
        int count1 = 0;
        int count2 = 0;
        int i = 0;
        int j = size - 1;
        if (min == l - 1) {
            while (i < size && list.get(i) == min) {
                count1++;
                i++;
            }
        }
        if (max == r + 1) {
            while (j >= i && list.get(j) == max) {
                count2++;
                j--;
            }
        }
        if (count2 == 0) {
            return -1;
        }
        int tmp = count1 - count2;
        if (tmp == 0) {
            return count1;
        } else if (tmp > 0) {
            int count = 0;
            while (j >= i) {
                if (list.get(j) - 1 >= l) {
                    count++;
                    j--;
                } else {
                    break;
                }
            }
            if (count >= tmp) {
                return tmp;
            } else {
                return -1;
            }
        } else {
            int count = 0;
            tmp = -tmp;
            while (i <= j) {
                if (list.get(i) + 1 <= r) {
                    count++;
                    i++;
                } else {
                    break;
                }
            }
            if (count >= tmp) {
                return tmp;
            } else {
                return -1;
            }
        }
    }

    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String str = in.next();
            int n = str.length();
            int total = 0;
            for (int i = 0; i < n; i++) {
                int count = 0;
                if (str.charAt(i) == '0') {
                    total++;
                } else {
                    count++;
                }
                int j = i - 1;
                for (; j >= 0; j--) {
                    int len = i - j + 1;
                    if (str.charAt(j) == '1') {
                        count++;
                    }
                    if (len * 1.0 / 2 > count) {
                        total++;
                    }
                }
            }
            System.out.println(total);
        }
    }
}
