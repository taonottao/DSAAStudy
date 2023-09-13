package exam;


import java.util.*;

public class Demo7 {

    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String s = in.nextLine();
            String[] strs = in.nextLine().split(",");
            HashMap<Character, Integer> hash = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (hash.containsKey(ch)) {
                    hash.put(ch, hash.get(ch) + 1);
                } else {
                    hash.put(ch, 1);
                }
            }
            HashMap<String, String> map = new HashMap<>();
            List<String> list = new ArrayList<>();
            for (int i = 0; i < strs.length; i++) {
                String str = strs[i];
                StringBuilder tmp = new StringBuilder();
                for (int j = 0; j < str.length(); j++) {
                    char res = str.charAt(j);
                    if (hash.containsKey(res)) {
                        tmp.append(hash.get(res));
                    } else {
                        tmp.append(0);
                    }
                }
                list.add(tmp.toString());
                map.put(tmp.toString(), str);
            }
            Collections.sort(list);
            for (int i = 0; i < list.size(); i++) {
                String str = list.get(i);
                if (i == 0) {
                    System.out.print("[");
                }
                System.out.print(map.get(str));
                if (i < list.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String[] s = in.nextLine().split(",");
            int tar = Integer.parseInt(in.nextLine());
            int[] arr = new int[s.length];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == tar) {
                    min = 1;
                    break;
                }
                int len = 1;
                int sum = arr[i];
                int j = i - 1;
                for (; j >= 0; j--) {
                    len++;
                    sum += arr[j];
                    if (sum == tar) {
                        break;
                    }
                }
                if (sum != tar) {
                    len = 1;
                }
                if (len > 1) {
                    min = Math.min(min, len);
                }
            }
            min = min == Integer.MAX_VALUE ? 0 : min;
            System.out.println(min);
        }
    }
}
