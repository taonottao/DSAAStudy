package exam;


import java.util.*;

public class Demo9 {
    static List<String> list = new ArrayList<>();
    static StringBuilder path = new StringBuilder();

    public static void main1(String[] args) {
        HashMap<Integer, String> hash = new HashMap<>();
        hash.put(2, "abc");
        hash.put(3, "def");
        hash.put(4, "ghi");
        hash.put(5, "jkl");
        hash.put(6, "mno");
        hash.put(7, "pqrs");
        hash.put(8, "tuv");
        hash.put(9, "wxyz");
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String s = in.next();

            func1(s, 0, hash);
            System.out.println(list);
        }
    }

    public static void func1(String s, int pos, HashMap<Integer, String> hash) {
        if (pos == s.length()) {
            String str = "\"" + path + "\"";
            list.add(str);
            return;
        }
        int index = s.charAt(pos) - '0';
        String tmp = hash.get(index);
        for (int i = 0; i < tmp.length(); i++) {
            path.append(tmp.charAt(i));
            func1(s, pos + 1, hash);
            path.deleteCharAt(path.length() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String s = in.next();
            String[] strs = s.split(",");
            int[] arr = new int[strs.length];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(strs[i]);
            }
            List<List<Integer>> list = new ArrayList<>();
            Arrays.sort(arr);
            func(arr, list);
            System.out.println(list);
        }
    }
    // -4 -1 -1 0 1 2
    private static void func(int[] arr, List<List<Integer>> list) {
        int left = 0;
        int right = arr.length-1;
        while (left < right) {
            int a = arr[left] + arr[right];
            for (int i = left + 1; i < right; i++) {
                if (arr[i] == -a) {
                    List<Integer> list1 = new ArrayList<>();
                    list1.add(arr[left]);
                    list1.add(arr[i]);
                    list1.add(arr[right]);
                }
            }
            left++;
            right--;
        }
    }
}
