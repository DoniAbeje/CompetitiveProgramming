public class MergeSort {

    public static void main(String[] args) {
        int[] unsorted = SelectionSort.generateRandom();
        for (int i : sort(unsorted))
            System.out.println(i);
    }

    public static int[] sort(int[] nums) {
        if (nums.length < 2)
            return nums;

        int mid = nums.length / 2;
        int[] firstHalf = sort(slice(nums, 0, mid));
        int[] secondHalf = sort(slice(nums, mid, nums.length));

        return merge(firstHalf, secondHalf);
    }

    public static int[] merge(int[] firstHalf, int[] secondHalf) {
        int[] result = new int[firstHalf.length + secondHalf.length];
        int x = 0, y = 0, z = 0;

        while (x < firstHalf.length && y < secondHalf.length) {

            if (firstHalf[x] <= secondHalf[y]) {
                result[z] = firstHalf[x];
                x++;
            } else {
                result[z] = secondHalf[y];
                y++;
            }
            z++;
        }

        while (x < firstHalf.length) {
            result[z] = firstHalf[x];
            x++;
            z++;
        }

        while (y < secondHalf.length) {
            result[z] = secondHalf[y];
            y++;
            z++;
        }
        return result;
    }

    private static int[] slice(int[] nums, int from, int to) {
        int[] result = new int[to - from];
        for (int i = 0; i < result.length; i++) {
            result[i] = nums[from];
            from++;
        }
        return result;
    }
}