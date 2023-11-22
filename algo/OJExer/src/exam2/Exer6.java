package exam2;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/11/22 18:37
 */

//class A {
//    int i;
//
//    A(int i) {
//        this.i = i*2;
//    }
//}

//class Exer6 extends A{
//
//    public static void main(String[] args) {
//        Exer6 b = new Exer6(2);
//    }
//
//    Exer6(int i) {
//        System.out.println(i);
//    }
//}
class Exer6{

    public static void main(String[] args) {
//        int x = 4;
//        System.out.println("a is " + ((x > 4) ? 99.9 : 9));
        int i = 0;
        int j = 0;
        if ((++i > 0) || (++j > 0)) {
            System.out.println(i + ", " + j);
        }
    }

}
