package leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合总和
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/9/22 12:26
 */
public class Exer39 {
    List<List<Integer>> ret;
    List<Integer> path;
    int aim;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        aim = target;
        path = new ArrayList<>();
        ret = new ArrayList<>();
        dfs(nums, 0, 0);
        return ret;
    }
    private void dfs(int[] nums, int pos, int sum){
        if(sum == aim){
            ret.add(new ArrayList<>(path));
            return;
        }
        if(sum > aim || pos >= nums.length){
            return;
        }
        for(int i = pos; i < nums.length; i++){
            path.add(nums[i]);
            dfs(nums, i, sum + nums[i]);
            path.remove(path.size() - 1);
        }
    }
}
