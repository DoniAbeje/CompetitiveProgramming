import java.util.Stack;

public class PrefixCalculator {

    public static void main(String[] aStrings) {
        System.out.println(compute("* 5 + 4 - 3 2"));
    }

    public static int compute(String input) {
        Stack<Integer> stack = new Stack<Integer>();

        for (String c : new StringBuilder(input).reverse().toString().split(" ")) {
            if (c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/")) {
                stack.push(calculate(stack.pop(), stack.pop(), c.charAt(0)));
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
