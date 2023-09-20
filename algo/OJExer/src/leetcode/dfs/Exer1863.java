package leetcode.dfs;

/**
 * 找出所有子集的异或总和再求和
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/9/19 9:16
 */
public class Exer1863 {
    int path;
    int sum;
    public int subsetXORSum(int[] nums) {
        dfs(nums, 0);
        return sum;
    }
    private void dfs(int[] nums, int pos){
        sum += path;
        for(int i = pos; i < nums.length; i++){
            path ^= nums[i];
            dfs(nums, i + 1);
            path ^= nums[i];
        }
    }
}
