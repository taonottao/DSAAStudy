package Demo3;

import java.util.HashMap;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/8/5 8:33
 */
public class Exer2 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,2,2};
        int value = getValue(arr, 5);
//        HashMap<Integer, Integer> count = new HashMap<>();
//        count.put(1, 0);
        System.out.println(value);
    }

    public static int getValue(int[] gifts, int n) {
        // write code here
        int half = n / 2;
        HashMap<Integer, Integer> count = new HashMap<>();
        for(int i = 0; i < n; i++){
            if(!count.containsKey(gifts[i])){
                count.put(gifts[i], 1);
            } else {
                count.replace(gifts[i], count.get(gifts[i]), count.get(gifts[i]) + 1);
            }
        }
        for(Integer key : count.keySet()){
            int actCount = count.get(key);
            if(actCount > half){
                return key;
            }
        }
        return 0;
    }
}
