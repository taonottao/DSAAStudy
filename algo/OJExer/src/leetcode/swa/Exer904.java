package leetcode.swa;

import java.util.HashMap;
import java.util.Map;

/**
 * 水果成篮
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/11/24 20:23
 */
public class Exer904 {
    public int totalFruit(int[] f) {
        Map<Integer, Integer> hash = new HashMap<>();
        int ret = 0;

        for(int l = 0, r = 0; r < f.length; r++){
            int in = f[r];
            hash.put(in, hash.getOrDefault(in, 0) + 1);
            while(hash.size() > 2){
                int out = f[l++];
                hash.put(out, hash.get(out) - 1);
                if(hash.get(out) == 0){
                    hash.remove(out);
                }
            }
            ret = Math.max(ret, r - l + 1);
        }
        return ret;
    }
}
