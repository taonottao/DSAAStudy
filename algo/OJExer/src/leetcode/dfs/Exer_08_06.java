package leetcode.dfs;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 汉诺塔问题
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/8/31 17:10
 */
public class Exer_08_06 {
    public void hanota(List<Integer> a, List<Integer> b, List<Integer> c) {
        dfs(a, b, c, a.size());
    }

    public void dfs(List<Integer> a, List<Integer> b, List<Integer> c, int n){
        if(n == 1){
            c.add(a.remove(a.size() - 1));
            return;
        }
        dfs(a, c, b, n - 1);
        c.add(a.remove(a.size() - 1));
        dfs(b, a, c, n - 1);

//        PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                int height1 = Integer.parseInt(o1.split(" ")[1]);
//                int weight1 = Integer.parseInt(o1.split(" ")[2]);
//                int height2 = Integer.parseInt(o2.split(" ")[1]);
//                int weight2 = Integer.parseInt(o2.split(" ")[2]);
//
//            }
//        });
    }
}
