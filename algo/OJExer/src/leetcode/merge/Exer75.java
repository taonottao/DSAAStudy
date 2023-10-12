package leetcode.merge;

/**
 * 颜色分类
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/10/11 10:53
 */
public class Exer75 {
    public void sortColors(int[] nums) {
        int left = -1;
        int i = 0;
        int right = nums.length;
        while(i < right){
            if(nums[i] == 0){
                swap(nums, ++left, i++);
            }else if(nums[i] == 1){
                i++;
            }else{
                swap(nums, --right, i);
            }
        }
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
