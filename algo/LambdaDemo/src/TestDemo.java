import org.junit.Test;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/4/23 18:31
 */
public class TestDemo {

    @Test
    public void test1(){
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("this");
        list.add("day");

        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        System.out.println("**********************************");

        list.forEach(s -> System.out.println(s));

        System.out.println("**********************************");

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        list.forEach(s -> System.out.println(s));

        System.out.println("**********************************");

        list.sort((o1, o2) -> o1.compareTo(o2));
        list.forEach(s -> System.out.println(s));
    }

    @Test
    public void test2(){
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("hello", 3);
        hashMap.put("abc", 2);
        hashMap.put("this", 5);

        hashMap.forEach(new BiConsumer<String, Integer>() {
            @Override
            public void accept(String s, Integer integer) {
                System.out.println("key: " + s +  "val: " + integer);
            }
        });

        System.out.println("******************************");

        hashMap.forEach((s, integer) -> System.out.println("key: " + s +  "val: " + integer));
    }

}
