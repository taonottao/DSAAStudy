package exam;


import java.time.LocalDateTime;
import java.util.Date;

public class Demo18 {
    public static void main(String[] args) {
//        long date = new Date(2023-07-03).getTime();
//        System.out.println(date);
        System.out.println(func());
    }

    public static int func() {
        try {
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            return 2;
        }
    }
}
