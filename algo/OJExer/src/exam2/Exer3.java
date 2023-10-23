package exam2;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/10/22 16:24
 */
public class Exer3 {
    public static void main1(String[] args) {
        int i = 4;
        int j = 5;
        System.out.println(i++ > 4 & ++j > 5);
        System.out.println(i);
        System.out.println(j);
    }


    public static void main2(String[] args) {
        Thread t = new Thread(() -> {
            try {
                pong();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.run();
        System.out.println("ping");
    }

    static void pong() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("pong");
    }

    public static void main(String[] args) {

        System.out.println(7.2%3);
    }
}
