import java.util.Stack;

public class ValidParenteses {

    public static void main(String[] args) {
        System.out.println(isValid("]"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();

        for (Character c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
                continue;
            }

            if (stack.isEmpty()) {
                return false;
            }

            switch (c) {
                case '}':
                    if (stack.pop() != '{') {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.pop() != '[') {
                        return false;
                    }
                    break;
                case ')':
                    if (stack.pop() != '(') {
                        return false;
                    }
                    break;
            
                default:
                    break;
            }


        }
        return stack.isEmpty();
    }
}