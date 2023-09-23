package exam;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Demo11 {
    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
            }
            int ret = func(nums);
            System.out.println(ret);
        }
    }

    private static int func(int[] nums) {

        int n = nums.length;
        int[] f = new int[n];
        int[] g = new int[n];
        f[0] = nums[0];
        for (int i = 1; i < n; i++) {
            f[i] = g[i-1] + nums[i];
            g[i] = Math.max(f[i-1], g[i-1]);
        }

        return Math.max(f[n-1], g[n-1]);
    }

    public static void main2(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            int n = Integer.parseInt(in.nextLine());
            List<String> list = new ArrayList<>();
            for(int i = 0; i < n; i++){
                int flag = 0;
                int index = 0;
                String cur = in.nextLine();
                char[] ch = cur.toCharArray();
                if (Integer.parseInt(cur) % 2 == 0) {
                    list.add(cur);
                    continue;
                }
                for(int j = 0; j < ch.length; j++){
                    int tmp = ch[j] - '0';
                    if (tmp % 2 == 0) {
                        index = j;
                        flag = 1;
                        break;
                    }
                }
                if (flag == 1) {
                    char tmp = ch[index];
                    ch[index] = ch[ch.length-1];
                    ch[ch.length-1] = tmp;
                    list.add(String.valueOf(ch));
                } else {
                    list.add("-1");
                }
            }
            for (String str : list) {
                System.out.println(str);
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String str = in.nextLine();
            int left = str.indexOf("[") + 1;
            int right = str.lastIndexOf("]");
            str = str.substring(left, right);
            String[] strs = str.split(",");
            int[] nums = new int[strs.length];
            for (int i = 0; i < strs.length; i++) {
                nums[i] = Integer.parseInt(strs[i]);
            }
            Arrays.sort(nums);
            List<List<Integer>> ret = find(nums);
            System.out.println();
        }
    }
    public static List<List<Integer>> find(int[] nums){
        List<List<Integer>> ret = new ArrayList<>();

        int n = nums.length;
        for(int i = 0; i < n; i++){
            List<Integer> tmp = new ArrayList<>();
            int a = -nums[i];
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                if (nums[left] + nums[right] == a) {
                    tmp.add(-a);
                    int b = nums[left];
                    int c = nums[right];
                    tmp.add(b);
                    tmp.add(c);
                    ret.add(new ArrayList<>(tmp));
                    tmp.clear();
                    while (nums[left] == b) {
                        left++;
                    }
                    while (nums[right] == c) {
                        right--;
                    }
                } else if (nums[left] + nums[right] > a) {
                    right--;
                } else {
                    left++;
                }
            }

            while (i < n && nums[i] == -a) {
                i++;
            }
            i--;
        }
        return ret;
    }
}
