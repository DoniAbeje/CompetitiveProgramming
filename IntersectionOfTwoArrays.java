import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {

    public static void main(final String[] args) {
        for (int num : intersection(new int[]{1,2,2,1}, new int[]{2,2})) {
            System.out.println(num);
        }
    }

    public static int[] intersection(final int[] nums1, final int[] nums2) {
        Set<Integer> intersections = new HashSet<Integer>();

        for (int i : nums1) {
            for (int j : nums2) {
                if (i == j) {
                    intersections.add(i);
                    break;
                }
            }
        }

        int[] result = new int[intersections.size()];

        int counter = 0;
        for (Integer i : intersections) {
            result[counter] = i;
            counter++;
        }

        return result;
    }
}