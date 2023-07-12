package my_sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/7/10 16:31
 */
public class TestSort {
    public static void main1(String[] args) {
        int[] arr = {12,56,32,67,10,19,4};
        InsertSort insertSort = new InsertSort();
//        insertSort.insertSort(arr);
//        insertSort.shellSort(arr);
        SelectSort selectSort = new SelectSort();
//        selectSort.selectSort(arr);
//        selectSort.selectSort2(arr);
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        char[] c = {'a','b','c','d'};
        String s = String.valueOf(c);

//        String str = "hello";
//        char a = ' ';
//        str.replace('e','');
//        char c = 'b';
//        System.out.println(c + "");
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int total = 0;
            int[] sum = new int[3*n];
            for(int i = 0; i < 3*n; i++){
                sum[i] = in.nextInt();
            }
            Arrays.sort(sum);
            int i = sum.length - 2;
            while(n > 0){
                total += sum[i];
                i -= 2;
                n--;
            }
            System.out.println(total);
        }
    }


    @Test
    public void test(){
//        String str = "abcdefe";
//        String e = str.replace('e', '*');
        String a = "They are students";
        String b = "aeiou";
        char[] cs = new char[a.length()];
        for(int i = 0; i < b.length(); i++){
            char c = b.charAt(i);
            if(a.contains(c+"")){
                a = a.replace(c, '*');
            }
        }
        int j = 0;
        int count = 0;
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i)!= '*'){
                cs[j] = a.charAt(i);
                count++;
                j++;
            }
        }
        String str = String.valueOf(cs);
        str = str.substring(0, count);
        System.out.println(str.length());
        System.out.println(str);

//        char[] c = {'a', ' ', 'b'};
//        String s = String.valueOf(c);
//        System.out.println(s);
    }
    @Test
    public void tset2(){
//        System.out.println("Thy r stdnts." == "Thy r stdnts.");
        char[][] cs = new char[1][2];
    }
}
