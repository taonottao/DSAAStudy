package exam;


import java.util.*;

public class Demo15 {
    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String str = in.nextLine();
            boolean ret = isDNS(str);
            System.out.println(ret);
        }
    }

    public static boolean isDNS(String str) {
        if (str.length() > 255) {
            return false;
        }
        str = str.toLowerCase();
        String[] strings = str.split("\\.", -1);
        if (strings.length < 2) {
            return false;
        }
        for (int i = 0; i < strings.length; i++) {
            String tmp = strings[i];
            if (tmp.length() != 0 && tmp.length() <= 63 && tmp.charAt(0) != '-' && tmp.charAt(tmp.length()-1) != '-') {
                for(int j = 0; j < tmp.length(); j++){
                    char ch = tmp.charAt(j);
                    if ((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9') || ch == '-') {
                        continue;
                    } else {
                        return false;
                    }
                }
            } else {
                return false;
            }

        }
        return true;
    }

    public static void main2(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int x = in.nextInt();
            List<Integer> list = new ArrayList<>();
            HashMap<Integer, Integer> hash = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int a = in.nextInt();
                int b = in.nextInt();
                if (!list.contains(a)) {
                    list.add(a);
                }
                if (hash.containsKey(a)) {
                    hash.put(a, hash.get(a) + b);
                } else {
                    hash.put(a, b);
                }
            }
            Collections.sort(list);
            int max = 0;
            for (int i = 0; i < list.size(); i++) {
                int a = list.get(i);
                int b = hash.get(a);
                int tar = a + x;
                int tmp = i+1;
                while (tmp < list.size() && list.get(tmp) <= tar) {
                    if (hash.containsKey(list.get(tmp))) {
                        b += hash.get(list.get(tmp));
                    }
                    tmp++;
                }
                max = Math.max(max, b);
            }
            System.out.println(max);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            for (int i = 0; i < n; i++) {
                HashMap<Integer, Integer> hash = new HashMap<>();
                int num = in.nextInt();
                for (int j = 0; j < num; j++) {
                    int a = in.nextInt();
                    int b = in.nextInt();
                    hash.put(b, a);
                }
            }
        }
    }

    public String substr (String a, String b) {
        // write code here

        HashMap<Character, List<Integer>> hash = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            char ch = a.charAt(i);
            if (hash.containsKey(ch)) {
                List<Integer> list = hash.get(ch);
                list.add(i);
                hash.put(ch, list);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                hash.put(ch, list);
            }
        }
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < b.length(); i++) {
            if (hash.containsKey(b.charAt(i))) {
               lists.add(hash.get(b.charAt(i)));
            } else {
                return "";
            }
        }

        return "";
    }

}
















