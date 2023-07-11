package Demo1;

import java.util.*;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/7/10 9:36
 */
class Student implements Comparable<Student>{
    public int age;
    public String name;

    public Student(String name, int age) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Student o) {
        // 小根堆
//        return this.age - o.age;
        // 大根堆
        return o.age - this.age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (age != student.age) return false;
        return Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        int result = age;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}

class NameComparator implements Comparator<Student>{

    @Override
    public int compare(Student o1, Student o2) {
        return o1.name.compareTo(o2.name);
    }
}

class AgeComparator implements Comparator<Student>{

    @Override
    public int compare(Student o1, Student o2) {
        return o1.age-o2.age;
    }
}

public class PriorityQueueTest {
    public static void main(String[] args) {

        

        String str1 = "abc";
        String str2 = "acba";
        String str3 = "abda";
        Queue<String> priorityQueue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int len = Math.min(o1.length(), o2.length());
                for (int i = 0; i < len; i++) {
                    char c1 = o1.charAt(i);
                    char c2 = o2.charAt(i);
                    if(c1 != c2){
                        return c1 - c2;
                    }
                }
                return o1.compareTo(o2);
            }
        });
        priorityQueue.offer(str1);
        priorityQueue.offer(str2);
        priorityQueue.offer(str3);
        System.out.println("*************");
    }
    public static void main4(String[] args) {
        Queue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // 大根堆
                return o2.compareTo(o1);
            }
        });
        priorityQueue.offer(1);
        priorityQueue.offer(2);
        System.out.println("*************");
    }
    public static void main3(String[] args) {
        Student s1 = new Student("zhangsan",11);
        Student s2 = new Student("zhangsan",12);
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
        System.out.println(s1.compareTo(s2));

        NameComparator nameComparator = new NameComparator();
        System.out.println(nameComparator.compare(s1, s2));

        AgeComparator ageComparator = new AgeComparator();
        System.out.println(ageComparator.compare(s1, s2));
    }
    public static void main1(String[] args) {

        List<Integer> list = new ArrayList<>();

        // 默认小根堆
        Queue<Object> priorityQueue = new PriorityQueue<>(list);
        priorityQueue.offer(1);
        priorityQueue.offer(2);
        // 不能放不可比较的对象
//        priorityQueue.offer(new String("asc"));
        Queue<Student> priorityQueue2 = new PriorityQueue<>();
//        priorityQueue2.offer(new Student("zhangsan", 18));
//        priorityQueue2.offer(new Student("lisi", 19));
        // 不能放 null
//        priorityQueue2.offer(null);
    }

    /**
     * 找前 k 个最大值
     * N*Logk
     * @param arr
     * @param k
     * @return
     */
    public static int[] findKMax(int[] arr, int k){
        int[] ret = new int[k];
        if (arr == null || k == 0) {
            return ret;
        }
        Queue<Integer> minHeap = new PriorityQueue<>(k);
        // K*LogK
        for (int i = 0; i < k; i++) {
            minHeap.offer(arr[i]);
        }
        // (N-K)Logk
        for (int i = k; i < arr.length; i++) {
            if(arr[i] > minHeap.peek()){
                minHeap.poll();
                minHeap.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; i++) {
            ret[i] = minHeap.poll();
        }

        return ret;

    }

    public static void main2(String[] args) {
        int[] arr = {1,5,43,3,2,7,98,41,567,78};
        int[] kMax = findKMax(arr, 3);
        System.out.println(Arrays.toString(kMax));
    }
}
