import java.util.ArrayList;

public class QueueWithStack {

    public static void main(String[] args) {
        
    }
}

class MyQueue {

    ArrayList<Integer> list = new ArrayList<Integer>();
    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        list.add(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int result = list.get(0);
        list.remove(0);
        return result;
    }

    /** Get the front element. */
    public int peek() {
        return list.get(0);
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return list.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such: MyQueue obj =
 * new MyQueue(); obj.push(x); int param_2 = obj.pop(); int param_3 =
 * obj.peek(); boolean param_4 = obj.empty();
 */