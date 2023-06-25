import java.util.*;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/6/24 20:25
 */
public class Exer17 {

    public static void main(String[] args) {
//        int[] arr = new int[]{3,3,2,1,3,3,3,1};
//        int i = maxLength(arr);
//        System.out.println(i);
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1,2);
        map.put(3,9);
        System.out.println(map.get(3));
    }

    /**
     * 最长无重复子数组
     * @param arr
     * @return
     */
    public static int maxLength1 (int[] arr) {
        // write code here
        if(arr.length <= 1){
            return arr.length;
        }
        // int count = 1;
        int maxLen = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i : arr){
            while (queue.contains(i)){
                queue.poll();
            }
            queue.offer(i);
            maxLen = Math.max(maxLen, queue.size());
        }

        return maxLen;
    }
    public static int maxLength (int[] arr) {
        // 3,3,2,1,3,3,3,1
        if (arr.length == 0)
            return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0, j = 0; i < arr.length; ++i) {
            if (map.containsKey(arr[i])) {
                j = Math.max(j, map.get(arr[i]) + 1);
            }
            map.put(arr[i], i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }
}
