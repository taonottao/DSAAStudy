package exam;

import com.sun.deploy.util.StringUtils;

import java.util.*;

public class Demo13 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String s = in.nextLine();
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            System.out.println(new String(ch));
        }
    }

    public long countPairs(ArrayList<Integer> arr, int n, int sum) {
        // write code here
        Collections.sort(arr);
        long count = 0;
        HashMap<Integer, Integer> hash = new HashMap<>();
        int index = -1;
        for (int i = 0; i < n; i++) {
            int tmp = arr.get(i);
            if (tmp >= sum / 2.0 && index == -1) {
                index = i;
            }
            if (hash.containsKey(tmp)) {
                hash.put(tmp, hash.get(tmp) + 1);
            } else {
                hash.put(tmp, 1);
            }
        }

        for (int i = 0; i < index; i++) {
            int a = arr.get(i);
            int b = sum - a;
            int count1 = hash.get(a);
            int count2 = hash.containsKey(b)?hash.get(b):0;
            count += count1 * count2;
            while (arr.get(i) == a) {
                i++;
            }
            i--;
        }
        int ret = 0;
        if (arr.get(index) == sum / 2.0) {
            int tmp = hash.get(arr.get(index));
            for(int i = 0; i < tmp; i++){
                for(int j = i + 1; j < tmp; j++){
                    ret = ret + 1;
                }
            }
        }
        count += ret;
        return count;
    }


}
