package Demo1;

import java.util.*;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/7/10 15:28
 */
public class PriorityQueueTest2 {
    public static void main(String[] args) {

        int[] arr = {4,5,1,6,2,7,3,8};
        ArrayList<Integer> list = GetLeastNumbers_Solution(arr, 4);
        System.out.println("***************");
    }
    public static ArrayList<Integer> GetLeastNumbers_Solution (int[] input, int k) {
        // write code here
        if(input == null || k == 0){
            return null;
        }
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> maxHeap = new PriorityQueue<>(k,new Comparator<Integer>(){
            public int compare(Integer o1, Integer o2){
                return o2.compareTo(o1);
            }
        });
        for(int i = 0; i < k; i++){
            maxHeap.offer(input[i]);
        }
        for(int i = k; i <input.length; i++){
            if(input[i] < maxHeap.peek()){
                maxHeap.poll();
                maxHeap.offer(input[i]);
            }
        }

        while(!maxHeap.isEmpty()){
            list.add(maxHeap.poll());
        }


        return list;
    }
}
