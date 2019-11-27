import java.util.Random;

public class SelectionSort {
    public static void main(String[] args) {
        int[] unsorted = generateRandom();
        for (int i : sort(unsorted)) {
            System.out.println(i);
        }
    }

    public static int[] sort(int[] nums) {
        int unsortedIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            int smallestIndex = getSmallestIndex(nums, unsortedIndex);
            nums = swap(nums, unsortedIndex, smallestIndex);
            unsortedIndex++;
        }
        return nums;
    }

    public static int getSmallestIndex(int[] nums, int from) {
        int small = from;
        for (int i = from; i < nums.length; i++) {
            if (nums[i] < nums[small]) {
                small = i;
            }
        }
        return small;
    }

    public static int[] swap(int[] nums, int first, int second) {
        int firstNumber = nums[first];
        nums[first] = nums[second];
        nums[second] = firstNumber;
        return nums;
    }

    public static int[] generateRandom() {
        Random random = new Random();
        return random.ints(0, 100000).limit(10000).distinct().toArray();
    }

}