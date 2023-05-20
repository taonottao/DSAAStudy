
import java.util.*;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/5/19 8:08
 */
public class Exer3 {
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int score = 0;
        if(s.length()<=4){
            score = 5;
        }else if(s.length() <= 7){
            score = 10;
        }else {
            score = 25;
        }
        Set<Character> set1 = new HashSet<>();
        List<Character> set2 = new ArrayList<>();
        List<Character> set3 = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) >= 65 && s.charAt(i) <= 91){
                set1.add('A');
            }else if(s.charAt(i) >= 97 && s.charAt(i) <= 123){
                set1.add('a');
            }

            if(s.charAt(i) >= 48 && s.charAt(i) <= 57){
                set2.add(s.charAt(i));
            }

            if((s.charAt(i) >= 0x21 && s.charAt(i)<=0x2F) ||
                    (s.charAt(i) >= 0x3A && s.charAt(i)<=0x40) ||
                    (s.charAt(i) >= 0x5B && s.charAt(i)<=0x60) ||
                    (s.charAt(i) >= 0x7B && s.charAt(i)<=0x7E)){
                set3.add(s.charAt(i));
            }
        }
        if(set1.size()==1){
            score += 10;
        }else if(set1.size()==2){
            score += 20;
        }
        if(set2.size()==1){
            score += 10;
        } else if (set2.size() > 1) {
            score +=  20;
        }
        if(set3.size()==1){
            score += 10;
        } else if (set3.size() > 1) {
            score +=  25;
        }
        if(set1.size()==2 && !set2.isEmpty() && !set3.isEmpty()){
            score += 5;
        } else if (set1.size() == 1 && !set2.isEmpty() && !set3.isEmpty()) {
            score += 3;
        } else if (!set1.isEmpty() && !set2.isEmpty()) {
            score += 2;
        }

        if(score>=90){
            System.out.println("VERY_SECURE");
        } else if (score>=80){
            System.out.println("SECURE");
        } else if (score >= 70) {
            System.out.println("VERY_STRONG");
        } else if (score >= 60) {
            System.out.println("STRONG");
        } else if (score >= 50) {
            System.out.println("AVERAGE");
        } else if (score >= 25) {
            System.out.println("WEAK");
        } else if (score >= 0) {
            System.out.println("VERY_WEAK");
        }
    }


    public static void main(String[] args) {
        Employee e = new Employee("123");
        System.out.println(e.empID);
    }
}

class Person {
    String name = "No name";
    public Person(String nm) {
        name = nm;
    }
}
class Employee extends Person {
    String empID = "0000";
    public Employee(String id) {
        super(id);
        empID = id;
    }
}



