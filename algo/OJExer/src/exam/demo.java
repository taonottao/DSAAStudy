package exam;


import java.util.*;

public class demo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                int a = in.nextInt();
                arr[i] = a;
            }
            int max = find(arr);
            System.out.println(max);
        }
    }

    private static int find(int[] arr) {
            Deque<Integer> queue = new ArrayDeque<>();
            int max = 1;
            for (int i = 0; i < arr.length; i++) {
                while (queue.contains(arr[i])) {
                    queue.poll();
                }
                queue.offer(arr[i]);
                max = Math.max(max, queue.size());
            }
            return max;
    }

//    private static int find(List<Integer> list) {
//        List<Integer> list1 = new ArrayList<>();
//        list1.add(list.get(0));
//        int n = list.size();
//        int[] dp = new int[n];
//        for (int i = 0; i < n; i++) {
//            dp[i] = 1;
//        }
//        int max = 1;
//        for (int i = 1; i < n; i++){
//            if (!list1.contains(list.get(i))) {
//                dp[i] = dp[i-1] + 1;
//            }
//            list1.add(list.get(i));
//            max = Math.max(max, dp[i]);
//        }
//        return max;
//    }

//    public static int find(List<Integer> list, int left, int n) {
//        List<Integer> tmp = new ArrayList<>();
//        for (int i = left; i < n; i++) {
//            if (!tmp.contains(list.get(i))) {
//                tmp.add(list.get(i));
//            } else {
//                break;
//            }
//        }
//        return tmp.size();
//    }


//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNextInt()) {
//            int n = in.nextInt();
//            int[] arr = new int[n];
//            for (int i = 0; i < n; i++) {
//                int a = in.nextInt();
//                arr[i] = a;
//            }
//            Arrays.sort(arr);
//            int sum = 0;
//            for (int i = 1; i < n; i++) {
//                if(arr[i] <= arr[i-1]){
//                    sum += arr[i-1] + 1 - arr[i];
//                    arr[i] = arr[i-1] + 1;
//                }
//            }
//            System.out.println(sum);
//        }
//    }


//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNextInt()) {
//            int n = in.nextInt();
//            int u = in.nextInt();
//            int v = in.nextInt();
//            double tmp = u*1.0/v;
//            double[] arr = new double[n];
//            for (int i = 0; i < n; i++) {
//                int a = in.nextInt();
//                arr[i] = a*1.0;
//            }
//            int count = 0;
//            for (int i = 0; i < n; i++) {
//                double sum = arr[i];
//                for (int j = i + 1; j < n; j++) {
//                    sum += arr[j];
//                    if ((sum / (j - i + 1)) == tmp) {
//                        count++;
//                    }
//                }
//            }
//            System.out.println(count);
//        }
//    }
}
