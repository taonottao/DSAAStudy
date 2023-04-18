/**
 * 计数排序
 * 适用于一组集中在某个范围的数字排序
 *
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/4/18 20:09
 */
public class Sort5 {

    /**
     * 时间复杂度：
     * 空间复杂度：
     * 稳定性：
     * @param arr
     */
    public static void countSort(int[] arr){
        //1.遍历数组找到最大值和最小值
        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] < min){
                min = arr[i];
            }
            if(arr[i] > max){
                max = arr[i];
            }
        }
        //2.根据范围定义计数数组的长度
        int len = max - min + 1;
        int[] count = new int[len];
        //3.遍历数组，在计数数组中记录每个数字出现的次数
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]-min]++;
        }
        //4.遍历计数数组
        int index = 0;//arr数组新的下标
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0){
                arr[index] = i + min;
                index++;
                count[i]--;
            }
        }

    }

}
