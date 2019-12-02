import java.util.ArrayList;
import java.util.List;

public class PancakeSort {

    public static void main(String[] args) {
        for (int i : pancakeSort(new int[] { 3, 2, 4, 1 })) {
            System.out.print(i);
        }
    }

    public static List<Integer> pancakeSort(int[] A) {
        List<Integer> list = new ArrayList<>();

        for (int i = A.length; i > 1; i--) {
            if (A[i - 1] == i) {
                continue;

            } else if (A[0] == i) {
                A = reverse(A, i - 1);
                list.add(i);

            } else {
                for (int j = 0; j < A.length; j++) {
                    if (A[j] == i) {
                        A = reverse(A, j);
                        list.add(j + 1);
                    }
                }
                A = reverse(A, i - 1);
                list.add(i);
            }
        }
        return list;
    }

    public static int[] reverse(int[] A, int upTo) {
        int[] result = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            if (i <= upTo) {
                result[upTo - i] = A[i];
            } else {
                result[i] = A[i];
            }
        }
        return result;
    }
}