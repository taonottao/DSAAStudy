package leetcode.merge;

import java.util.Random;

/**
 * 排序 - 快排
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/10/11 12:11
 */
public class Exer912 {
    public int[] sortArray(int[] nums) {
        qsort(nums, 0, nums.length - 1);
        return nums;
    }

    private void qsort(int[] nums, int l, int r){
        if(l >= r) return;

        int key = nums[new Random().nextInt(r - l + 1) + l];
        int left = l - 1;
        int right = r + 1;
        int i = l;

        while(i < right){
            if(nums[i] < key){
                swap(nums, ++left, i++);
            }else if(nums[i] == key){
                i++;

            }else{
                swap(nums, --right, i);
            }
        }
        qsort(nums, l, left);
        qsort(nums, right, r);
    }
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
