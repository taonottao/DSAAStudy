package exam;


import java.util.*;

public class Demo2 {
    //    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNextInt()) {
//            int INF = (int) 1e7;
//            int n = in.nextInt();
//            int[] arr1 = new int[n];
//            int[] arr2 = new int[n];
//
//            for (int i = 0; i < n; i++) {
//                arr1[i] = (i + 1)% INF;
//                arr2[i] = (n - i)% INF;
//            }
//            if(n % 2 != 0){
//                int index = n/2;
//                int tmp = arr2[index];
//                arr2[index] = arr2[n-1];
//                arr2[n-1] = tmp;
//            }
//            int sum = 0;
//            for (int i = 0; i < n; i++) {
//                sum += Math.abs(arr1[i] - arr2[i]);
//            }
//            System.out.println(sum);
//        }
//    }
    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.next();
            char[] ch = str.toCharArray();
            int[] dp = new int[8];
            for (int i = 0; i < 8; i++) {
                dp[i] = 1;
            }
            for (int i = 1; i < ch.length; i++) {
                if (ch[i] - ch[i - 1] == 1 && ch[i] >= 'a' && ch[i] <= 'h') {
                    int index = ch[i] - 'a';
                    dp[index] = Math.max(dp[index - 1] + 1, dp[index]);
                }
            }
            int ret = 0;
            for (int i = 0; i < 8; i++) {
                if (dp[i] == i + 1) {
                    ret = i;
                }
            }
            int count = 1;
            int tmp = dp[ret];
            int[] arr = new int[8];
            for (int i = 0; i < 8; i++) {
                arr[i] = 1;
            }
            for (int i = 1; i < 8; i++) {
                for (int j = 0; j < i; j++) {
                    arr[i] += arr[j];
                }
            }
            for (int i = ret + 1; i < 8; i++) {
                count *= dp[i];
            }
            System.out.println(count);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[8];
//        for (int i = 0; i < 8; i++) {
//            arr[i] = 1;
//        }
        arr[0] = 1;
        for (int i = 1; i < 8; i++) {
            for (int j = 0; j < i; j++) {
                arr[i] += arr[j] + 1;
            }
        }
        System.out.println();
    }
}
