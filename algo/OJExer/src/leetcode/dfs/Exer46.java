package leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/9/17 10:45
 */
public class Exer46 {
    List<List<Integer>> ret;
    List<Integer> path;
    boolean[] check;
    public List<List<Integer>> permute(int[] nums) {
        ret = new ArrayList<>();
        path = new ArrayList<>();
        check = new boolean[nums.length];
        dfs(nums);
        return ret;
    }
    private void dfs(int[] nums){
        if(nums.length == path.size()){
            ret.add(new ArrayList(path));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(check[i] == false){
                path.add(nums[i]);
                check[i] = true;
                dfs(nums);
                check[i] = false;
                path.remove(path.size()-1);
            }
        }
    }
}
