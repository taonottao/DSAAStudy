import java.util.Scanner;
import java.util.Stack;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/6/6 8:24
 */
public class Exer6 {
    public static void main(String[] args) {
        func();
    }

    public static void func(){
        Scanner sc = new Scanner(System.in);
        double d1 =0;
        double d2 = 0;
        while(sc.hasNextInt()){
            d1 = sc.nextInt();
            d2 = sc.nextInt();
            if(d1 > d2*3.14*2){
                System.out.println("No");
            }else{
                System.out.println("Yes");
            }
        }

    }
}

class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minS;

    public MinStack() {
        stack = new Stack<>();
        minS  = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        minS.push(Math.min(val, minS.peek()));

    }

    public void pop() {
        stack.pop();
        minS.pop();

    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minS.peek();
    }
}
