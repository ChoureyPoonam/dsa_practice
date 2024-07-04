import java.util.ArrayList;

public class QuickSortProgram {


    private void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public static void main(String args[]) {
        int arr[] = {4, 1, 3, 9, 7};
        QuickSortProgram quickSortProgram = new QuickSortProgram();
        quickSortProgram.quickSortAlgorithm(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private void quickSortAlgorithm(int[] arr, int low, int high) {
        if (low < high) { // for more than one element
            int partition = findAndPlacePivot(arr, low, high);
            quickSortAlgorithm(arr, low, partition - 1);
            quickSortAlgorithm(arr, partition + 1, high);
        }

    }

    private int findAndPlacePivot(int[] arr, int low, int high) {
        int i = low;
        int j = high;
        int pivot = low;

        while (i < j) {
            while (arr[i] <= arr[pivot] && i < high) {
                i++;
            } // increment i till you find element which is greater that pivot
            while (arr[j] > arr[pivot] && j >= low) {
                j--;
            }// decrement j till you find element which is smaller than pivot
            if (i < j) swap(arr, i, j);
        }
        swap(arr, pivot, j);
        return j;
    }
}
