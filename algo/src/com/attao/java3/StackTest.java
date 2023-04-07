package com.attao.java3;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 栈
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/4/6 21:59
 */
public class StackTest {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        Integer a = stack.pop();
        System.out.println(a);
        Integer b1 = stack.peek();
        System.out.println(b1);
        Integer b2 = stack.peek();
        System.out.println(b2);
        System.out.println(stack.size());

    }

    /**
     *后缀表达式(逆波兰表达式)
     */
    @Test
    public void test1(){
        String[] strings = {"9", "3", "1", "-", "3", "*", "+", "10", "2", "/", "+"};
        int i = evalRPN(strings);
        System.out.println(i);
    }

    public int evalRPN(String[] tokens){
        Stack<Integer> stack = new Stack<>();
        for(String x : tokens){
            if(!isOperation(x)){
                stack.push(Integer.parseInt(x));
            }else {
                int num1 = stack.pop();
                int num2 = stack.pop();
                switch (x){
                    case "+":
                        stack.push(num2 + num1);
                        break;
                    case "-":
                        stack.push(num2 - num1);
                        break;
                    case "*":
                        stack.push(num2 * num1);
                        break;
                    case "/":
                        stack.push(num2 / num1);
                        break;
                }
            }
        }
        return stack.pop();
    }

    private boolean isOperation(String x){
        if("+".equals(x) || "-".equals(x) || "*".equals(x) || "/".equals(x)){
            return true;
        }

        return false;
    }


    /**
     * 括号匹配
     */
    @Test
    public void test2(){
        String s = new String("([()");
        boolean valid = isValid(s);
        System.out.println(valid);
    }

    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            }else {
                //遇到了右括号
                if(stack.empty()){
                    return false;//右括号多
                }
                char ch2 = stack.peek();
                if(ch == ')' && ch2 == '(' || ch == '}' && ch2 == '{' || ch == ']' && ch2 == '['){
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        if(!stack.empty()){
            return false;
        }

        return true;
    }


    /**
     * 出栈入栈匹配
     */
    @Test
    public void test3(){
        int[] arr1 = new int[]{1,2,3,4,5};
        int[] arr2 = new int[]{4,5,2,3,1};
        boolean popOrder = isPopOrder(arr1, arr2);
        System.out.println(popOrder);
    }

    public boolean isPopOrder(int[] pushA, int[] popA){
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i < pushA.length; i++) {

            stack.push(pushA[i]);

            while(j < popA.length && !stack.isEmpty() && stack.peek().equals(popA[j])){

                stack.pop();
                j++;

            }

        }

        return stack.isEmpty();

    }

    /**
     * LinkedList当做栈使用
     */
    @Test
    public void test4(){
        LinkedList<Integer> stack  = new LinkedList<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }
}
