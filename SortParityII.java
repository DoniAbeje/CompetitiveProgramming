public class SortParityII {

    public static void main(String[] args){
        int[] nums = new int[]{4,8,2,3,5,9};
        for (int i : sortArrayByParityII(nums)) {
            System.out.println(i);
        }
    }

    public static int[] sortArrayByParityII(int[] A) {
        int[] result = new int[A.length];
        int evenIndex = 0;
        int oddIndex = 1;

        for (int count = 0; count < A.length; count++) {
            if (A[count] % 2 == 0) {
                result[evenIndex] = A[count];
                evenIndex += 2;
            }
            else{
                result[oddIndex] = A[count];
                oddIndex += 2;
            }
        }
        return result;
    }
}