package exam;


import java.util.*;

public class Demo17 {
    public static void main1(String[] args) {
        System.out.println(1%10);
    }
    public static void main2(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            Arrays.sort(arr);
            int tmp = 1;
            for(int i = 0; i < n; i++){
                tmp *= arr[i];
            }
            int ret = 0;
            for (int i = 0; i < n; i++) {
                ret += (tmp-1) % arr[i];
            }
            System.out.println(ret);

        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            int k = Integer.parseInt(in.nextLine());
            String str = in.nextLine();
            if (str.length() < k) {
                System.out.println(-1);
            } else if (str.length() == k) {
                System.out.println(str);
            } else {
                int max = 0;
                HashMap<String, Integer> hash = new HashMap<>();
                for (int i = 0; i < str.length(); i++) {
                    for (int j = k; j < str.length() - i; j++) {
                        String tmp = str.substring(i, i+k);
                        if (hash.containsKey(tmp)) {
                            hash.put(tmp, hash.get(tmp) + 1);
                            max = Math.max(max, hash.get(tmp));
                        } else {
                            hash.put(tmp, 1);
                        }
                    }
                }
                List<String> list = new ArrayList<>();
                for (Map.Entry<String, Integer> entry : hash.entrySet()) {
                    int tmp = entry.getValue();
                    if (tmp == max) {
                        list.add(entry.getKey());
                    }
                }
                if (list.size() == 1) {
                    System.out.println(list.get(0));
                } else {
                    Collections.sort(list, new Comparator<String>() {
                        @Override
                        public int compare(String o1, String o2) {
                            if (o1.length() == o2.length()) {
                                List<String> tmp = new ArrayList<>();
                                list.add(o1);
                                list.add(o2);
                                Collections.sort(list);
                                return list.get(0)== o1?1:-1;
                            } else {
                                return o2.length() - o1.length();
                            }
                        }
                    });
                    System.out.println(list.get(0));
                }
            }
        }
    }

}
