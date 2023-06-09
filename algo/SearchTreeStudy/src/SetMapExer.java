import org.junit.Test;

import java.util.*;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/4/22 14:51
 */
public class SetMapExer {

    @Test
    public void test1(){
        int[]  arr = {1,2,3,4,1,5,6,8,3};
        Set<Integer> set = removeSame(arr);
        System.out.println(set);
        System.out.println(findFirstSame(arr));
        System.out.println(findSame(arr));
    }

    /**
     * 去掉重复的元素
     * @param arr
     * @return
     */
    public Set<Integer> removeSame(int[] arr){
        Set<Integer> hashSet = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            hashSet.add(arr[i]);
        }

        return hashSet;

    }

    /**
     * 找到第一个重复的元素
     * @param arr
     * @return
     */
    public int findFirstSame(int[] arr){
        Set<Integer> hashSet = new HashSet<>();

        for(int x : arr){
            if(!hashSet.contains(x)){
                hashSet.add(x);
            }else {
                return x;
            }
        }

        return -1;
    }

    /**
     * 统计数据出现的次数
     * @param arr
     */
    public Map<Integer, Integer> findSame(int arr[]){
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : arr){
            if(map.get(x) == null){
                map.put(x, 1);
            }else {
                int val = map.get(x);
                map.put(x, val+1);
            }
        }

        return map;
    }

    /**
     * 找到只出现一次的数据，假设只有一个数据只出现一次，其他都出现两次
     * @param arr
     * @return
     */
    public int singleNumber(int[] arr){
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if(!set.contains(arr[i])){
                set.add(arr[i]);
            }else {
                set.remove(arr[i]);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if(set.contains(arr[i])){
                return arr[i];
            }
        }
        return -1;
    }

    /**
     * 复制带随机指针的链表,返回新的头结点head
     * @param head
     * @return
     */
    public Node copyRandomList(Node head){
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null){
            Node node = new Node(cur.val);
            map.put(cur, node);
            cur = cur.next;
        }
        cur = head;
        while(cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }

        return map.get(head);
    }


    public int numJewelsInStones(String jewels, String stones){
        int count = 0;
        Set<Character> set = new HashSet<>();
        //1.遍历jewels
        for (int i = 0; i < jewels.length(); i++) {
            char ch = jewels.charAt(i);
            set.add(ch);
        }
        //2.遍历stones
        for (int i = 0; i < stones.length(); i++) {
            if(set.contains(stones.charAt(i))){
                count++;
            }
        }

        return count;
    }

    /**
     * 找出坏掉的键盘
     */
    public static void func(String str1, String str2){
        Set<Character> set = new HashSet<>();
        Set<Character> set1 = new HashSet<>();
        String s1 = str1.toUpperCase();
        String s2 = str2.toUpperCase();
        for (int i = 0; i < s2.length(); i++) {
            char  ch = s2.charAt(i);
            set.add(ch);
        }
        for (int i = 0; i < s1.length(); i++) {
            if(!set.contains(s1.charAt(i))){
                set1.add(s1.charAt(i));
            }
        }
        for(char ch : set1){
            System.out.print(ch);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()){
            String str1 = scan.nextLine();
            String str2 = scan.nextLine();
            func(str1, str2);
        }
    }

    /**
     * 给定一个单词列表words和一个整数k，返回前k个出现次数最多的单词。
     * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字典顺序排序。
     * @param words
     * @param k
     * @return
     */
    public List<String> topKFrequent(String[] words, int k){
        //1.遍历数组，统计每个单词出现的频率
        Map<String, Integer> hashMap = new HashMap<>();
        for (String s : words){
            if(hashMap.get(s) == null){
                hashMap.put(s, 1);
            }else {
                hashMap.put(s, hashMap.get(s) + 1);
            }
        }

        //2.建立小根堆
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(
                k, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(o1.getValue().compareTo(o2.getValue()) == 0){
                    return o2.getKey().compareTo(o1.getKey());
                }
                return o1.getValue().compareTo(o2.getValue());
            }
        }
        );
        //3.遍历hashMap，把里面的数据放到小根堆
        for(Map.Entry<String, Integer> entry : hashMap.entrySet()){
            if(minHeap.size() < k){
                minHeap.offer(entry);
            }else {
                //小根堆放满了k个，下一个entry和堆顶元素比较
                Map.Entry<String, Integer> top = minHeap.peek();
                if(top.getValue().compareTo(entry.getValue()) < 0){
                    minHeap.poll();
                    minHeap.offer(entry);
                }else {
                    //频率相同的情况
                    if(top.getValue().compareTo(entry.getValue()) == 0){
                        if(top.getKey().compareTo(entry.getKey()) > 0){
                            minHeap.poll();
                            minHeap.offer(entry);
                        }
                    }
                }
            }
        }
        //4.此时小根堆中已经有了结果

        List<String> ret = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            String key = minHeap.poll().getKey();
            ret.add(key);
        }
        Collections.reverse(ret);
//        System.out.println("ret:" + ret);
        return ret;
    }

    @Test
    public void test2(){
        String[] words = {"a","b","a","c","d","a","c","e","e","a","e"};
        topKFrequent(words, 3);
    }

}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
    }
}