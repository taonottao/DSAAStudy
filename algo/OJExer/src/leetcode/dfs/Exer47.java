package leetcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 全排列 II
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/9/19 9:33
 */
public class Exer47 {
    List<Integer> path;
    List<List<Integer>> ret;
    boolean[] check;
    public List<List<Integer>> permuteUnique(int[] nums) {
        path = new ArrayList<>();
        ret = new ArrayList<>();
        check = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums, 0);
        return ret;
    }

    private void dfs(int[] nums, int pos){
        if(pos == nums.length){
            ret.add(new ArrayList(path));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            // 剪枝
            if(check[i] == true || (i != 0 && nums[i] == nums[i-1] && check[i-1] == false)){
                continue;
            }

            path.add(nums[i]);
            check[i] = true;
            dfs(nums, pos + 1);
            // 回溯
            path.remove(path.size()-1);
            check[i] = false;
        }
    }
}
