import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class MatrixCellInDistanceOrder {

    public static void main(String[] args) {
        for (int[] a : allCellsDistOrder(2, 3, 1, 2)) {
            System.out.print("[ ");
            for (int b : a) {
                System.out.print(b);
            }
            System.out.println(" ]");
        }

    }

    public static int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] result = new int[R * C][2];
        ArrayList<int[]> list = new ArrayList<>();
        ArrayList<Integer> distances = new ArrayList<>();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int distance = Math.abs(r0 - i) + Math.abs(c0 - j);
                int[] cell = new int[] { distance, i, j };
                distances.add(distance);
                list.add(cell);

            }
        }

        Collections.sort(distances);

        for (int i = 0; i < distances.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (distances.get(i) == list.get(j)[0]) {
                    result[i] = new int[]{list.get(j)[1], list.get(j)[2]};
                    list.remove(j);
                    break;
                }
            }
        }

        return result;
    }
}