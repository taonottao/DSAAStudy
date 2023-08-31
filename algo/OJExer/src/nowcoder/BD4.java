package nowcoder;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 蘑菇阵
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/8/22 13:29
 */
public class BD4 {
    PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            if(o1.charAt(0) - o2.charAt(0) != 0){
                return o1.charAt(0) - o2.charAt(0);
            } else{
                return o2.charAt(1) - o1.charAt(1);
            }

        }
    });
}
