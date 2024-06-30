import java.util.ArrayList;

public class MergeSortProgram {
    public void mergeSort(int arr[], int low, int high) {
        if (low >= high) return;
        int mid = (low + high) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);

    }

    private void merge(int[] arr, int low, int mid, int high) {
        int left = low;
        int right = mid + 1;
        ArrayList<Integer> temp = new ArrayList<>();
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }
        for(int i = low; i<=high; i++){
            arr[i] = temp.get(i-low);
        }
    }


    public static void main(String args[]) {
        int arr[] = {3, 2, 8, 5, 1, 4, 23};
        MergeSortProgram mergeSortProgram = new MergeSortProgram();
        mergeSortProgram.mergeSort(arr,0,arr.length-1);

        for (int i:arr ) {
            System.out.print(i +" ");
        }

    }
}
