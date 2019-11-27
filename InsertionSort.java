public class InsertionSort {

    public static void main(String[] args) {
        int[] unsorted = new int[]{5,7,36,7,93,3};
        for (int i : sort(unsorted)) {
            System.out.println(i);
        }
    }

    public static int[] sort(int[] nums) {
        if (nums.length < 2) {
            return nums;
        }

        for (int x = 0; x < nums.length; x++) {
            for (int y = x - 1; y >= 0; y--) {

                if (nums[x] >= nums[y]) {
                    nums = insert(nums, x, y + 1);
                    break;
                }

                if (y == 0){
                    nums = insert(nums, x, 0);
                }
            }

        }
        return nums;
    }

    private static int[] insert(int[] nums, int x, int y) {
        int valueX = nums[x];
        for (int i = x - 1; i >= y; i--) {
            nums[i + 1] = nums[i];
        }
        nums[y] = valueX;
		return nums;
	}
}