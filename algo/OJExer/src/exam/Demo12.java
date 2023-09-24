package exam;


import java.util.*;

public class Demo12 {
    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int[] arr = new int[n];
            Map<Integer, Integer> hash = new HashMap<>();
            for (int i = 0; i < n; i++) {
                hash.put(in.nextInt(), i);
            }
            int now = 1;
            for (int i = 1; i <= n; i++) {
                int day = hash.get(i);
                now = Math.max(now, day);
                arr[i - 1] = now;
            }
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + 1 + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int n = Integer.parseInt(in.nextLine());
            for (int i = 0; i < n; i++) {
                String str = in.nextLine();
                
            }
        }
    }
}
