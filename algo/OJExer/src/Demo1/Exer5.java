package Demo1;

import java.util.HashMap;
import java.util.Map;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/8/6 19:34
 */
public class Exer5 {

    public static void main(String[] args) {
        int[] hours = {9, 9, 6, 0, 6, 9};
        int i = longestWPI(hours);
        System.out.println(i);
    }

    public static int longestWPI(int[] hours) {
        int n = hours.length;
        Map<Integer, Integer> map = new HashMap<>();
        int s = 0, res = 0;
        for (int i = 0; i < n; i++) {
            s += hours[i] > 8 ? 1 : -1;
            if (s > 0) {
                res = Math.max(res, i + 1);
            } else {
                if (map.containsKey(s - 1)) {
                    res = Math.max(res, i - map.get(s - 1));
                }
            }
            if (!map.containsKey(s)) {
                map.put(s, i);
            }
        }
        return res;
    }

}
