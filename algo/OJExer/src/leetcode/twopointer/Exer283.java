package leetcode.twopointer;

/**
 *  移动零
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/10/5 11:17
 */
public class Exer283 {
    public void moveZeroes(int[] nums) {
        int cur = 0;
        int dest = -1;
        while(cur < nums.length){
            if(nums[cur] != 0){
                dest++;
                int tmp = nums[dest];
                nums[dest] = nums[cur];
                nums[cur] = tmp;
            }
            cur++;
        }
    }
}
