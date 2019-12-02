public class LargestPerimeterTriangle {

    public static void main(String[] args) {
        System.out.println(largestPerimeter(new int[]{1,2,1}));
    }

    public static int largestPerimeter(int[] A) {
        A = sort(A);

        for (int i = A.length - 1 ; i >= 2; i--) {
            if (A[i] < A[i - 1] + A[i - 2]) {
                return A[i] + A[i - 1] + A[i - 2];
            }
        }

        return 0;
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

// [4,2,3,1] [1,4,2,3] [3,1,2,4] [3,4,2,1]
// [1,3,2,4] [4,1,2,3] [2,1,3,4] [4,3,2,1]
// [2,3,1,4] [3,2,1,4] 
// [3,2,1,4] 
