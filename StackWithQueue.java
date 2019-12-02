import java.util.ArrayList;

public class StackWithQueue {

    public static void main(String[] args) {
        
    }
}

class MyStack {

    ArrayList<Integer> list = new ArrayList<Integer>();
    /** Initialize your data structure here. */
    public MyStack() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        list.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int last = list.size() - 1;
        int result = list.get(last);
        list.remove(last);
        return result;

    }

    /** Get the top element. */
    public int top() {
        return list.get(list.size() - 1);
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return list.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such: MyStack obj =
 * new MyStack(); obj.push(x); int param_2 = obj.pop(); int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */