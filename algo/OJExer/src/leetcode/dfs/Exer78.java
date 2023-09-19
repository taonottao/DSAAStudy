package leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/9/18 12:55
 */
public class Exer78 {
    List<List<Integer>> ret;
    List<Integer> path;
    public List<List<Integer>> subsets(int[] nums) {

        ret = new ArrayList<>();
        path = new ArrayList<>();
        dfs(nums, 0);
        return ret;
    }
    // // 解法一
    // private void dfs(int[] nums, int pos){
    //     // 出口
    //     if(pos == nums.length){
    //         ret.add(new ArrayList(path));
    //         return;
    //     }
    //     // 选
    //     path.add(nums[pos]);
    //     dfs(nums, pos+1);
    //     path.remove(path.size()-1);//恢复现场
    //     // 不选
    //     dfs(nums, pos+1);
    // }

    // 解法二
    private void dfs(int[] nums, int pos){
        ret.add(new ArrayList<>(path));
        for(int i = pos; i < nums.length; i++){
            path.add(nums[i]);
            dfs(nums, i+1);
            path.remove(path.size()-1);
        }

    }
}
