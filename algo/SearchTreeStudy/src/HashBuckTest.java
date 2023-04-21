import org.junit.Test;

import java.util.Objects;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/4/21 19:18
 */

class Teacher{
    private String string_id;

    public Teacher() {
    }

    public Teacher(String string_id) {
        this.string_id = string_id;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "string_id='" + string_id + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Teacher teacher = (Teacher) o;

        return Objects.equals(string_id, teacher.string_id);
    }

    @Override
    public int hashCode() {
        return string_id != null ? string_id.hashCode() : 0;
    }
}

public class HashBuckTest {

    @Test
    public void test2(){
        HashBuck1<Teacher, String> hashBuck1 = new HashBuck1<>();
        Teacher t1 = new Teacher("1234");
        Teacher t2 = new Teacher("1234");
        hashBuck1.put(t1, "Tom");
        String val = hashBuck1.get(t2);
        System.out.println(val);
    }

    @Test
    public void test1(){
        Teacher t1 = new Teacher("1234");
        System.out.println(t1.hashCode());
        Teacher t2 = new Teacher("1234");
        System.out.println(t2.hashCode());
    }

    @Test
    public void test(){
        HashBuck hashBuck = new HashBuck();
        hashBuck.put(1, 11);
        hashBuck.put(2, 22);
        hashBuck.put(5, 55);
        hashBuck.put(8, 88);
        hashBuck.put(3, 33);
        hashBuck.put(4, 44);
        hashBuck.put(6, 66);
        hashBuck.put(7, 77);

        int val = hashBuck.get(5);
        System.out.println(val);

    }

}
