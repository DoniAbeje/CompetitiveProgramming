public class QuickSort {

    public static void main(String[] args) {
        int[] nums = new int[] { 4, 5, 2, 5, 9, 8 };
        QSort qSort = new QSort(nums);
        qSort.sort(0, nums.length - 1);

        for (int i : qSort.getNums()) {
            System.out.print(i + " ");
        }
    }

     static class QSort {
        private int[] nums;

        public QSort(int[] nums) {
            this.nums = nums;
        }

        public int[] getNums(){
            return this.nums;
        }

        public void sort(int low, int high) {
            if (low < high) {

                int partitionIndex = partition(low, high);
                sort(low, partitionIndex - 1);
                sort(partitionIndex + 1, high);

            }
        }

        private int partition(int low, int high) {
            int pivot = nums[high];
            int counter = low - 1;

            for (int i = low; i < high; i++) {
                if (nums[i] < pivot) {
                    counter++;
                    swap(i, counter);
                }
            }
            counter++;
            swap(counter, high);
            return counter;
        }

        private void swap(int i, int j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

}