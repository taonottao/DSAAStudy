package exam;

import java.awt.font.NumericShaper;
import java.util.*;

public class Demo21 {

    public static void main1(String[] args) {
        String str = "ACBTMfxcc";
        int ret = countSeq(str);
        System.out.println(ret);
    }

    public static int countSeq (String mystr) {
        // write code here
        String s1 = mystr.toLowerCase();
        char[] chars = s1.toCharArray();
        HashMap<Character, Integer> hash = new HashMap<>();
        int max = 0;
        int min = Integer.MAX_VALUE;
        int cCount = 0;
        for (int i = 0; i < s1.length(); i++) {
            char ch = chars[i];
            if (hash.containsKey(ch)) {
                hash.put(ch, hash.get(ch) + 1);
            } else {
                hash.put(ch, 1);
            }
        }
        for(Map.Entry<Character, Integer> entry : hash.entrySet()){
            char ch = entry.getKey();
            if (ch == 'c') {
                cCount = entry.getValue();
            }
            if (ch == 'b' || ch == 't' || ch == 'f') {
                max = Math.max(max, entry.getValue());
                min = Math.min(min, entry.getValue());
            }
        }
        if (cCount <= 1 || min == 0) {
            return 0;
        }
        min = Math.min(cCount / 2, min);
        return min;
    }


    public static void main(String[] args) {
        String str = "aabbcc";
        int ret = Delete_character(str);
        System.out.println(ret);
    }

    public static int Delete_character (String s) {
        // write code here
        char[] chars = s.toCharArray();
        int[] nums = new int[26];
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            nums[ch -97]++;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                queue.offer(nums[i]);
            }
        }
        int i = queue.poll();
        while (!queue.isEmpty()) {
            int tmp = queue.poll();
            if (tmp == i) {
                count++;
                tmp--;
                if(tmp > 0)
                    queue.offer(tmp);
            } else {
                i = tmp;
            }
        }

        return count;
    }

}
