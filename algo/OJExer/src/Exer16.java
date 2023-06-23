import java.util.ArrayList;
import java.util.Arrays;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/6/23 18:51
 */
public class Exer16 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param num int整型一维数组
     * @return int整型ArrayList<ArrayList<>>
     */
    public ArrayList<ArrayList<Integer>> threeSum (int[] num) {
        // write code here
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        int n = num.length;
        if(n < 3){
            return lists;
        }
        Arrays.sort(num);
        for(int i = 0; i < n - 2; i++){
            if(i != 0 && num[i]==num[i-1]){
                continue;
            }
            int left = i + 1;
            int right = n - 1;
            int target = -num[i];
            while(left < right){
                if(num[left] + num[right] > target){
                    right--;
                }else if(num[left] + num[right] < target){
                    left++;
                }else{
                    ArrayList<Integer> temp = new ArrayList<Integer>();
                    temp.add(num[i]);
                    temp.add(num[left]);
                    temp.add(num[right]);
                    lists.add(temp);
                    while(left+1 <right && num[left] == num[left+1]){
                        left++;
                    }
                    while(right-1 > left && num[right]==num[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                }
            }
        }

        return lists;
    }
}
