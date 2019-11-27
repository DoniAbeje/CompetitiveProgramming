public class RelativeSortArray {

    public static void main(String[] args) {
        int[] nums1 = new int[] { 2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] nums2 = new int[] { 2, 1, 4, 3, 9, 6};
        for (int i : relativeSortArray(nums1, nums2)) {
            System.out.println(i);
        }
    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length];
        int[] nonCommon = new int[arr1.length - arr2.length];
        int resultIndex = 0, nonCommonIndex = 0;

        for (int j = 0; j < arr2.length; j++) {
            for (int i = 0; i < arr1.length; i++) {
                if (arr1[i] == arr2[j]) {
                    result[resultIndex] = arr2[j];
                    resultIndex++;
                }
            }
        }

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    break;
                }
                if (j == arr2.length - 1) {
                    nonCommon[nonCommonIndex] = arr1[i];
                    nonCommonIndex++;
                }
            }
        }
        nonCommon = sort(nonCommon);
        int nonStartIndex = nonCommon.length - (result.length - resultIndex);
        for (; resultIndex < result.length; resultIndex++) {
            result[resultIndex] = nonCommon[nonStartIndex];
            nonStartIndex++;
        }

        return result;
    }

    //util
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