import java.util.Stack;

public class PostfixCalculator {

    public static void main(String[] args) {
        
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();

        for (String c : tokens) {
            if (c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/")) {
                int first = stack.pop();
                stack.push(calculate(stack.pop(), first, c.charAt(0)));
            } else {
                stack.push(Integer.valueOf(c));
            }
        }

        return stack.pop();
    }

    public static int calculate(int operand1, int operand2, char operator) {
        switch (operator) {
        case '-':
            return operand1 - operand2;

        case '+':
            return operand1 + operand2;

        case '*':
            return operand1 * operand2;

        case '/':
            return operand1 / operand2;

        default:
            return 0;
        }
    }
}