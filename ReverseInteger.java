import java.util.ArrayList;

public class ReverseInteger {

    public static void main(String[] args) {
        System.out.println(reverse(-1));
    }

    public static int reverse(int x) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        long result = 0;
        
        while (x != 0) {
            int remainder = x % 10;
            x = x / 10;
            list.add(remainder);
        }

        for (int i = 0; i < list.size(); i++) {
            result = result + (list.get(i) * (long) Math.pow(10, list.size() - 1 - i));
            if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
                return 0;
            }
        }

        return (int) result;

    }
}