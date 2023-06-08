import java.util.LinkedList;
import java.util.Queue;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/6/8 17:05
 */
public class MyStack {
    // 队列实现栈
    private Queue<Integer> qu1;
    private Queue<Integer> qu2;

    public MyStack(){
        qu1 = new LinkedList<>();
        qu2 = new LinkedList<>();
    }

    public void push(int val){
        if(!qu1.isEmpty()){
            qu1.offer(val);
        } else if (!qu2.isEmpty()) {
            qu2.offer(val);
        }else {
            qu1.offer(val);
        }
    }

    public int pop(){
        if(Empty()){
            throw new RuntimeException("当前栈内无元素!!!");
        }
        if(!qu1.isEmpty()){
            int size = qu1.size();
//            while(qu1.size() > 1){ 此时 qu1 的大小在变化
            while(size > 1){
                qu2.offer(qu1.poll());
                size--;
            }
            return qu1.poll();
        } else {
            int size = qu2.size();
            while(size > 1){
                qu1.offer(qu2.poll());
                size--;
            }
            return qu2.poll();
        }
    }

    public boolean Empty(){
        return qu1.isEmpty() && qu2.isEmpty();
    }

    public int top(){
        if(Empty()){
            throw new RuntimeException("当前栈内无元素!!!");
        }
        if(!qu1.isEmpty()){
            int size = qu1.size();
            int val = -1;
            while(size > 0){
                val = qu1.poll();
                qu2.offer(val);
                size--;
            }
            return val;
        } else {
            int size = qu2.size();
            int val = -1;
            while(size > 0){
                val = qu1.poll();
                qu1.offer(val);
                size--;
            }
            return val;
        }
    }


}
