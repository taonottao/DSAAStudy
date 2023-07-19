package Demo1;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/7/14 8:13
 */
class A {
    public A() {
        System.out.println("A");
    }
    static {
        System.out.println("A static");
    }
}

class B extends A {
    public B() {
        System.out.println("B");
    }
    static {
        System.out.println("B static");
    }
}

public class Test {
    static B b = new B();

    public static void main(String[] args) {
        new A();
        new B();
    }
}
